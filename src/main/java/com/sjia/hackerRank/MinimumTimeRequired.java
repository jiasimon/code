package com.sjia.hackerRank;

public class MinimumTimeRequired {
    // https://www.hackerrank.com/challenges/minimum-time-required/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search

    /*
    total: 12;  prodcution array{ 4,5,6}  resultMin = 20
    20/4 + 20/ 5 + 20/6 = 12
    array length <= 100000
    machine[i] <= 10^9
     */

    static long minTime(long[] machines, long goal) {
        long result = -1;
        long lower = 0;
//        long upper = Integer.MAX_VALUE;     // Failed Test Case7,8,9
//        long upper = 1000000000000L;      // failed test case7
        long upper = 10000000000000L;  // 10^13 ,  10^9 x 10^5

        while (lower <= upper) {
            long middle = (lower + upper) / 2;
            if (computeItemNum(machines, middle) >= goal) {
                result = middle;

                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return result;


    }

    static long computeItemNum(long[] machines, long days) {
        long itemNumber = 0;
        for (long machine : machines) {
            itemNumber += days / machine;

            if (itemNumber > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return  itemNumber;
    }


}
