package com.sjia.Leetcode;

public class SuperWashingMachines {
    // #517. Super Washing Machines     https://leetcode.com/problems/super-washing-machines/description/

    /*
    You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.

    For each move, you could choose any m (1 <= m <= n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time.

    Given an integer array machines representing the number of dresses in each washing machine from left to right on the line, return the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.


    Input: machines = [1,0,5]       Output: 3

    Input: machines = [0,3,0]       Output: 2

    Input: machines = [0,2,0]       Output: -1

    1 <= n <= 10000
    0 <= machines[i] <= 10^5
     */


    // Math.max(moves, Math.max(Math.abs(balance), diff))
    //
    public int findMinMoves(int[] machines) {
        int total = 0;
        int n = machines.length;

        for (int machine : machines) {
            total += machine;
        }

        if (total % n != 0) {
            return -1; // If total clothes cannot be divided evenly
        }

        int target = total / n;
        int moves = 0, balance = 0;

        for (int load : machines) {
            int diff = load - target;
            balance += diff;
            moves = Math.max(moves, Math.max(Math.abs(balance), diff));
        }

        return moves;
    }

    public static void main(String[] args) {
        SuperWashingMachines solution = new SuperWashingMachines();

        int[] machines = {1, 0, 8};

        int minMoves = solution.findMinMoves(machines);
        System.out.println("Minimum moves required: " + minMoves);
    }

}
