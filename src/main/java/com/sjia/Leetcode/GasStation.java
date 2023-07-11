package com.sjia.Leetcode;

import java.util.Arrays;

public class GasStation {
    // #134. Gas Station    https://leetcode.com/problems/gas-station/
    /*
    There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i]
    it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

    return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

    Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]    Output: 3
    Input: gas = [2,3,4], cost = [3,4,3]    Output: -1

    1 <= n <= 10^5
    0 <= gas[i], cost[i] <= 10^4
     */


    // 2 pass , stream sum
    // 11 ms, 7.90%; 55.2 MB, 84.97%
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() - Arrays.stream(cost).sum() < 0) return -1;

        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }


    // 2 passes, for loop instead of stream sum
    // 2 ms, 99.88%; 55.6 MB, 38.19%
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        //determine if we have a solution
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }

        // find out where to start
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length;i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }


    // 1 pass
    public int canCompleteCircuitGreedy(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            tank  += gas[i] - cost[i];
            if(tank < 0){
                tank  = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }



    public static void main(String[] args) {
        GasStation solution = new GasStation();

        // Test case
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = solution.canCompleteCircuit(gas, cost);

        // Print the result
        System.out.println("Starting Gas Station: " + result);  // Output: 3

        int[] gas2 = {7, 1, 0, 11, 4};
        int[] cost2 = {5, 9, 1, 2, 5};
        int result2 = solution.canCompleteCircuit(gas2, cost2);
        System.out.println("Starting Gas Station: " + result2);  // Output: 3

    }


}
