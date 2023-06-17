package com.sjia.Leetcode;

public class InterleavingString {
    // #97. Interleaving String  https://leetcode.com/problems/interleaving-string/

    /*
        Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

    An interleaving of two strings s and t is a configuration where s and t are divided into n and m
    substrings
     respectively, such that:

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
    Note: a + b is the concatenation of strings a and b.
     */


    // DP, first row, first column
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base cases
        dp[0][0] = true;

        // Initialize the first row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Initialize the first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill in the rest of the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[m][n];
    }


    // recursive, Time Limit Exceeded
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0) return s2.equals(s3);
        if (s2.length() == 0) return s1.equals(s3);
        if (s3.charAt(0) != s1.charAt(0) && s3.charAt(0) != s2.charAt(0)) {
            return false;
        }
        if (s3.charAt(0) == s1.charAt(0) && s3.charAt(0) == s2.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1)) ||
                    isInterleave(s1, s2.substring(1), s3.substring(1));
        } else if (s3.charAt(0) == s1.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        } else if (s3.charAt(0) == s2.charAt(0)) {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        return false;
    }


    public static void main(String[] args) {
        InterleavingString solution = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean isInterleaved = solution.isInterleave(s1, s2, s3);
        System.out.println("Is s3 an interleaving string of s1 and s2? " + isInterleaved);
    }


}
