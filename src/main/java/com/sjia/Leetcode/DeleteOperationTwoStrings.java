package com.sjia.Leetcode;

public class DeleteOperationTwoStrings {
    // #583. Delete Operation for Two Strings   https://leetcode.com/problems/delete-operation-for-two-strings/description/

    /*
    Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

    In one step, you can delete exactly one character in either string.

    Input: word1 = "sea", word2 = "eat"     Output: 2

    Input: word1 = "leetcode", word2 = "etco"   Output: 4

    1 <= word1.length, word2.length <= 500
    word1 and word2 consist of only lowercase English letters.
     */

    // dp,
    // 150 ms, 5.36%, 
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j; // Delete all characters up to this point
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]); // Delete one character from either word
                }
            }
        }

        return dp[m][n];
    }

    // Test case
    public static void main(String[] args) {
        DeleteOperationTwoStrings solution = new DeleteOperationTwoStrings();

        String word1 = "sea";
        String word2 = "eat";

        System.out.println("Test Case 1: " + solution.minDistance(word1, word2)); // Output: 2
    }
}
