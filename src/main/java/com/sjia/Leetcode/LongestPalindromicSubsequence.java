package com.sjia.Leetcode;

public class LongestPalindromicSubsequence {
    // #516. Longest Palindromic Subsequence    https://leetcode.com/problems/longest-palindromic-subsequence/

    /*
    Given a string s, find the longest palindromic subsequence's length in s.

    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

    Input: s = "bbbab"  Output: 4
    Input: s = "cbbd"   Output: 2

    1 <= s.length <= 1000
    s consists only of lowercase English letters.
     */


    // dp[][],  dp[i][j] = dp[i + 1][j - 1] + 2;
    // 39 ms, 59.3%; 55.4 MB, 6.60%
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        // Create a 2D array to store the lengths of palindromic subsequences
        int[][] dp = new int[n][n];

        // Initialize the diagonal elements to 1 (each character is a palindrome of length 1)
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the dp array for different subsequence lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();

        String input = "bbbab";

        int longestLength = solution.longestPalindromeSubseq(input);
        System.out.println("Length of the longest palindromic subsequence: " + longestLength);
    }
}
