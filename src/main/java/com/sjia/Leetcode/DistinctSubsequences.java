package com.sjia.Leetcode;

import java.util.Arrays;

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

    compare to Hackerrank CommonChild DP formula;
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


    // recursive
    public int numDistinctRecursive(String s, String t) {
        return countDistinctSubsequences(s, t, 0, 0);
    }

    private int countDistinctSubsequences(String s, String t, int sIndex, int tIndex) {
        // Base cases
        if (tIndex == t.length()) {
            return 1; // Found a valid subsequence
        }
        if (sIndex == s.length()) {
            return 0; // Reached the end of s but still have unmatched characters in t
        }

        int count = 0;

        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            // If the characters match, we have two choices:
            // 1. Include the current character in both s and t
            // 2. Exclude the current character from s but keep it in t
            count += countDistinctSubsequences(s, t, sIndex + 1, tIndex + 1);
            count += countDistinctSubsequences(s, t, sIndex + 1, tIndex);
        } else {
            // If the characters don't match, we can only exclude the current character from s
            count += countDistinctSubsequences(s, t, sIndex + 1, tIndex);
        }

        return count;
    }



    // recursive, match from end to start
    public int numDistinct2(String s, String t)
    {
        return findSubS(s.length()-1, t.length()-1, s, t);
    }
    public int findSubS(int i, int j, String s, String t)
    {
        // base-case
        if(j<0) return 1;
        if(i<0) return 0;
        // match
        if(s.charAt(i)==t.charAt(j))
        {
            // take + notTake
            return findSubS(i-1, j-1, s, t) + findSubS(i-1, j, s, t);
        }
        // not-match
        return findSubS(i-1, j, s, t);
    }




    // DP memoization
    // 20 ms, 79.14% ; 47.3 MB, 39.4%
    public int numDistinctMemo(String s, String t)
    {
        int [][]dp = new int[s.length()][t.length()];
        for(int []row: dp) Arrays.fill(row, -1);
        return findSubS(s.length()-1, t.length()-1, s, t, dp);
    }
    public int findSubS(int i, int j, String s, String t, int [][]dp)
    {
        // base-case
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        // match
        if(s.charAt(i)==t.charAt(j))
        {
            // take + notTake
            return dp[i][j]= findSubS(i-1, j-1, s, t, dp) + findSubS(i-1, j, s, t, dp);
        }
        // not-match
        return dp[i][j]= findSubS(i-1, j, s, t, dp);
    }


    public static void main(String[] args) {
        DistinctSubsequences solution = new DistinctSubsequences();

        // Test Case 1
        String s1 = "rabbbit";
        String t1 = "rabbit";
        int result1 = solution.numDistinctRecursive(s1, t1);
        System.out.println("Distinct Subsequences: " + result1);  // Output: 3

        // Test Case 2
        String s2 = "babgbag";
        String t2 = "bag";
        int result2 = solution.numDistinctRecursive(s2, t2);
        System.out.println("Distinct Subsequences: " + result2);  // Output: 5


        String s3 = "HARRY";
        String t3 = "SALLY";
        int result3 = solution.numDistinct(s3, t3);
        System.out.println("Distinct Subsequences: " + result3);
    }




}
