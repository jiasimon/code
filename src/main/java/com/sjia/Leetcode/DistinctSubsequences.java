package com.sjia.Leetcode;

public class DistinctSubsequences {
    // #115. Distinct Subsequences  https://leetcode.com/problems/distinct-subsequences/
    /*
    Given two strings s and t, return the number of distinct subsequences of s which equals t.

    The test cases are generated so that the answer fits on a 32-bit signed integer.

    Input: s = "rabbbit", t = "rabbit"
    Output: 3
    Explanation:
    As shown below, there are 3 ways you can generate "rabbit" from s.
    rabb b it
    ra b bbit
    rab b bit
     */


    // DP, first column, first row
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first column of dp with 1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp array using dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If the characters match, we have two choices:
                    // 1. Include the current character in both s and t
                    // 2. Exclude the current character from s but keep it in t
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If the characters don't match, we can only exclude the current character from s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }




}
