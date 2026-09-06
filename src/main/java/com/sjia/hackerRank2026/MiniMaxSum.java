package com.sjia.hackerRank2026;

import java.util.List;

public class MiniMaxSum {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-mini-max-sum

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long sum=0;
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for( int n : arr) {
            sum += n;
            if (n < min) min = n;
            if (n > max) max = n;
        }
        System.out.println((sum-max) + " " + (sum-min));

    }
}
