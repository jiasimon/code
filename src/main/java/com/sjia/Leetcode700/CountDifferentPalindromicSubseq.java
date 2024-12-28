package com.sjia.Leetcode700;

public class CountDifferentPalindromicSubseq {
    // #730. Count Different Palindromic Subsequences   https://leetcode.com/problems/count-different-palindromic-subsequences/description/
    /*
Dynamic Programming:
    Use a 2D array dp[i][j] where dp[i][j] represents the count of distinct palindromic subsequences in the substring s[i:j+1].

Transitions:
    If s[i] == s[j]:
        Add contributions of the substring between i and j plus palindromes formed by adding s[i] and s[j].
    If s[i] != s[j]:
        Combine results of substrings [i+1, j] and [i, j-1], and subtract the overlap for [i+1, j-1].

Handle Duplicates:
    Use pointers to find the first and last occurrences of s[i] in the substring [i+1, j-1].

Base Cases:
    Single characters are palindromes, so dp[i][i] = 1.

Result:
    The answer is stored in dp[0][n-1].


     */

    // failed on s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;

        // dp[i][j] will store the count of distinct palindromic subsequences in s[i:j+1]
        int[][] dp = new int[n][n];

        // Base case: Single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill dp for substrings of increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    int low = i + 1, high = j - 1;

                    // Find the first and last occurrence of s[i] in s[i+1:j]
                    while (low <= high && s.charAt(low) != s.charAt(i)) low++;
                    while (low <= high && s.charAt(high) != s.charAt(i)) high--;

                    if (low > high) {
                        // No matching character inside, add two new palindromes: s[i] and s[i:j]
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (low == high) {
                        // One matching character inside, add one new palindrome: s[i:j]
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        // Two or more matching characters, subtract the overlapping part
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                    }
                } else {
                    // If s[i] != s[j], combine results of [i+1, j] and [i, j-1], subtract overlap
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }

                // Handle modulo to avoid negative results
                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }

        return dp[0][n - 1];
    }


    public static void main(String[] args) {
        CountDifferentPalindromicSubseq solution = new CountDifferentPalindromicSubseq();

        // Test Case 1
        String s1 = "bccb";
        System.out.println(solution.countPalindromicSubsequences(s1)); // Output: 6

        // Test Case 2
        String s2 = "abcd";
        System.out.println(solution.countPalindromicSubsequences(s2)); // Output: 4

        // Test Case 3
        String s3 = "aaaa";
        System.out.println(solution.countPalindromicSubsequences(s3)); // Output: 15
    }

}
