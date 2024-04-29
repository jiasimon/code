package com.sjia.Leetcode;

public class KInversePairsArray {
    // #629. K Inverse Pairs Array  https://leetcode.com/problems/k-inverse-pairs-array/description/
    /*
    For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].

    Given two integers n and k, return the number of different arrays consisting of numbers from 1 to n such that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 10^9 + 7.

    Input: n = 3, k = 0  Output: 1
    Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pairs.

    Input: n = 3, k = 1 Output: 2
    Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
     */


    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
                if (j >= i) {
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + mod) % mod;
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        KInversePairsArray solution = new KInversePairsArray();

        // Test Case
        int n = 3, k = 0;
        System.out.println("Test Case 1: " + solution.kInversePairs(n, k)); // Output: 1
    }

}
