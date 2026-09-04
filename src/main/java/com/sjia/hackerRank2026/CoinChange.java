package com.sjia.hackerRank2026;

import java.util.List;

public class CoinChange {
    // https://www.hackerrank.com/challenges/coin-change/problem

    // 3/17 test cases failed , bug : integer overflow
    public static long getWays(int n, List<Long> c) {
        // Write your code here
//        int[] dp = new int[n+1];
        long[] dp = new long[n+1];
        dp[0] = 1;

        for (long coin: c) {
            for (long i = coin; i<=n; i++) {
                dp[(int)i] += dp[(int)(i-coin)];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        runTest(1, 4, List.of(1L, 2L, 3L), 4L);
        runTest(2, 10, List.of(2L, 5L, 3L, 6L), 5L);
        runTest(3, 0, List.of(1L, 2L, 5L), 1L);
        runTest(4, 5, List.of(10L, 20L), 0L);
        runTest(5, 250, List.of(8L, 47L, 13L, 24L, 35L, 19L, 26L, 23L, 39L, 29L, 7L, 21L, 40L, 14L, 32L, 25L, 22L, 18L, 30L, 10L, 41L, 2L, 9L, 31L, 58L), 15685693751L);
    }

    private static void runTest(int testNum, int n, List<Long> c, long expected) {
        long actual = getWays(n, c);
        boolean passed = actual == expected;

        System.out.printf("Test %d: n = %d, coins = %s%n", testNum, n, c);
        System.out.printf("  Expected: %d | Actual: %d -> %s%n%n", expected, actual, passed ? "PASSED" : "FAILED");
    }



}
