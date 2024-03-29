package com.sjia.Leetcode;

import java.util.Arrays;

public class MinimumTimeToRepairCars {
    // #2594. Minimum Time to Repair Cars   https://leetcode.com/problems/minimum-time-to-repair-cars/

    /*
    You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.

    You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.

    Return the minimum time taken to repair all the cars.

    Note: All the mechanics can repair the cars simultaneously.

    Input: ranks = [4,2,3,1], cars = 10     Output: 16
    Explanation:
    - The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
    - The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
    - The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
    - The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
    It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​

    Input: ranks = [5,1,8], cars = 6        Output: 16
    Explanation:
    - The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
    - The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
    - The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
    It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​

    // compare to hankrank MinimumTimeRequired
     */


    // binary search , return cnt >= cars
    // 33 ms, 87.74%; 54.6 MB; 23.58%
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = 1l * ranks[0] * cars * cars;

        while (left < right) {
            long m = (left + right ) / 2;
            if (check(ranks, cars, m)) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return left;
    }


    public boolean check(int[] ranks, int cars, long m) {
        long cnt = 0;
        for (int x : ranks) {
            cnt += (long) Math.sqrt(m / x);
        }
        return cnt >= cars;
    }


    // hard code  upper bound
    // 61 ms, 42.92%; 53.4 MB, 100%
    public long repairCars_binary(int[] ranks, int cars) {
        long l = 1;
        long r = 1000000000000000l;  // 10^15

        while ( l < r) {
            long m = ( l + r) / 2;
            if (  numCarsFixed(ranks, m) >= cars ) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;

    }


    // 57 ms, 50%; 54.1 MB, 60.85%
    public long repairCars_binary2(int[] ranks, int cars) {
        long l = 1;
        long r = 100000000000000l; // 10^14

        while ( l < r) {
            long m = ( l + r) / 2;
            if (  numCarsFixed(ranks, m) >= cars ) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;

    }


    private long numCarsFixed(int[] ranks, long minutes) {
        long carsFixed = 0;

        for ( int r : ranks) {
            carsFixed += Math.sqrt(minutes / r);
        }
        return carsFixed;
    }

    public static void main(String[] args) {
        MinimumTimeToRepairCars solution = new MinimumTimeToRepairCars();
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        long minTime = solution.repairCars_binary(ranks, cars);
        System.out.println("Minimum Time to Repair Cars: " + minTime); // Output: 16
    }







}
