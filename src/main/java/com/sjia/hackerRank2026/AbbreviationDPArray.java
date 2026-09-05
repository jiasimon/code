package com.sjia.hackerRank2026;

public class AbbreviationDPArray {
    // https://www.hackerrank.com/challenges/abbr/problem

    // 2D-dp
    // dp[i][j] = true if the first i characters of a can be transformed to match the first j characters of b.
    public static String abbreviation(String a, String b) {
        int n = a.length(), m = b.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Base case: consuming leading lowercase letters of a with empty b
        for (int i = 1; i <= n; i++) {
            if (Character.isLowerCase(a.charAt(i - 1))) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i <= n; i++) {
            char ca = a.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char cb = b.charAt(j - 1);
                if (Character.isUpperCase(ca)) {
                    // Must match b's character exactly; uppercase letters can't be deleted
                    dp[i][j] = dp[i - 1][j - 1] && ca == cb;
                } else {
                    // Lowercase: either delete it, or capitalize it to match cb
                    dp[i][j] = dp[i - 1][j] || (Character.toUpperCase(ca) == cb && dp[i - 1][j - 1]);
                }
            }
        }

        return dp[n][m] ? "YES" : "NO";
    }

}
