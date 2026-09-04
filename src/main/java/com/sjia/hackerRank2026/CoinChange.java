package com.sjia.hackerRank2026;

import java.util.List;

public class CoinChange {
    // https://www.hackerrank.com/challenges/coin-change/problem

    // 3/17 test cases failed , bug : integer overflow
    public static long getWays(int n, List<Long> c) {
        // Write your code here
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (long coin: c) {
            for (long i = coin; i<=n; i++) {
                dp[(int)i] += dp[(int)(i-coin)];
            }
        }
        return dp[n];
    }


    
}
