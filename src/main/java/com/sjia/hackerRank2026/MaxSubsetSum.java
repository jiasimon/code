package com.sjia.hackerRank2026;

import java.util.List;

public class MaxSubsetSum {
    // https://www.hackerrank.com/challenges/max-array-sum/problem

    public static int maxSubsetSum(List<Integer> arr) {
        int n = arr.size();
        if (n == 0) return 0;

        int[] dp = new int[n];
        dp[0] = Math.max(0, arr.get(0));
        if (n == 1) return dp[0];
        dp[1] = Math.max(dp[0], Math.max(0, arr.get(1)));

        for (int i=2; i < n; i++) {
            dp[i]=Math.max( Math.max(arr.get(i), dp[i-1]), dp[i-2]+arr.get(i));
        }
        return dp[n-1];
    }

}
