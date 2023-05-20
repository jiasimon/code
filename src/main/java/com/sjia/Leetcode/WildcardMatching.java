package com.sjia.Leetcode;

public class WildcardMatching {

    // #44. Wildcard Matching  https://leetcode.com/problems/wildcard-matching/description/
    // Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
    // '?' Matches any single character.
    // '*' Matches any sequence of characters (including the empty sequence).

    // Input: s = "aa", p = "a"  Output: false
    // Input: s = "aa", p = "*"  Output: true



    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // Create a boolean dp array to store the matching status
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty pattern matches empty string
        dp[0][0] = true;

        // Mark the first row as false (no pattern matches empty string)
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Iterate through the pattern and string
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentChar = p.charAt(j - 1);

                if (currentChar == '?' || currentChar == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentChar == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }


    public static boolean isMatchWildcard(String s, String p) {
        int i = 0;
        int j = 0;

        int starIndex = -1;
        int matchIndex = -1;

//        while (i < s.length() && j < p.length()) {
        while (i < s.length() ) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                i++;
                j++;
            } else if ((j < p.length()) && p.charAt(j) == '*' ) {

                starIndex = j;
                matchIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                matchIndex++;
                i = matchIndex;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();


    }



    public static void main(String[] args) {
        WildcardMatching solution = new WildcardMatching();
//        String s = "adceb";
//        String p = "*a*b";
        String s = "aa";
        String p = "a";
//        String s = "leetcode";
//        String p = "*e*t?d*";
        boolean isMatch = solution.isMatch(s, p);
        boolean isMatch2 = solution.isMatchWildcard(s, p);
        System.out.println(isMatch);
        System.out.println(isMatch2);
    }



}
