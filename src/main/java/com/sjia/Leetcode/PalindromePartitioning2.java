package com.sjia.Leetcode;

public class PalindromePartitioning2 {
    // #132. Palindrome Partitioning II https://leetcode.com/problems/palindrome-partitioning-ii/
    /*
    Return the minimum cuts needed for a palindrome partitioning of s.

    1 <= s.length <= 2000
    s consists of lowercase English letters only.

    Input: s = "aab"    Output: 1
    Input: s = "a"      Output: 0
    Input: s = "ab"     Output: 1

     */


    // dp, isPalindrome to store whether a substring from index i to j is a palindrome.
    // Then, we update dp[i] by considering two cases: if j is 0, we set dp[i] to 0 as it represents the start of a new palindrome substring;
    // otherwise, we update dp[i] to the minimum between dp[i] and dp[j - 1] + 1 to keep track of the minimum cuts needed so far.
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    if (j > 0) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    } else {
                        // if j==0, from start the substring is Palindrome
                        dp[i] = 0;
                    }
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioning2 solution = new PalindromePartitioning2();

        // Test case
        String s = "aabcbd";
        int result = solution.minCut(s);

        // Print the result: "aabcbd" =2
        System.out.println("Minimum Cuts: " + result);
    }




}
