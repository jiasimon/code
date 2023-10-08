package com.sjia.Leetcode;

import java.util.Arrays;

public class MaxDotProduct {
    // #1458. Max Dot Product of Two Subsequences   https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/?envType=daily-question&envId=2023-10-08

    /*
    Given two arrays nums1 and nums2.

    Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

    A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

    Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]     Output: 18
    Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
    Their dot product is (2*3 + (-2)*(-6)) = 18.

    Input: nums1 = [3,-2], nums2 = [2,-6,7]         Output: 21
    Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
    Their dot product is (3*7) = 21.

    1 <= nums1.length, nums2.length <= 500
    -1000 <= nums1[i], nums2[i] <= 1000
     */



    // dp, first row, column
    // failed on [-3,-8,3,-10,1,3,9], [9,2,3,7,-9,1,-8,5,-1,-1]
    public int maxDotProduct_dp1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;


        int[][] dp = new int[m][n];

        // Initialize dp[0][0] with the product of the first elements
        dp[0][0] = nums1[0] * nums2[0];

        // Initialize the first row of dp
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], nums1[0] * nums2[j]);
        }

        // Initialize the first column of dp
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        }

        // Fill in the rest of dp using the recurrence relation
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int maxPrev = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                dp[i][j] = Math.max(maxPrev, dp[i - 1][j - 1] + nums1[i] * nums2[j]);
                dp[i][j] = Math.max(maxPrev, Math.max(0, dp[i - 1][j - 1]) + nums1[i] * nums2[j]);
            }
        }

        return dp[m - 1][n - 1];
    }







    public static void main(String[] args) {
        MaxDotProduct solution = new MaxDotProduct();
//        int[] nums1 = {2, 1, -2, 5};
//        int[] nums2 = {3, 0, -6};

        int[] nums1 = {-3,-8,3,-10,1,3,9};
        int[] nums2 = {9,2,3,7,-9,1,-8,5,-1,-1};

        int maxDot = solution.maxDotProduct_dp1(nums1, nums2);
        System.out.println("Max Dot Product: " + maxDot); // Output: 200 instead of 194
    }
}
