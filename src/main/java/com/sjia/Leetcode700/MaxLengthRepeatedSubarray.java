package com.sjia.Leetcode700;

public class MaxLengthRepeatedSubarray {
    // #718. Maximum Length of Repeated Subarray    https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
    /*

    Dynamic Programming Table (dp):

    Let dp[i][j] represent the length of the longest common subarray ending at nums1[i - 1] and nums2[j - 1].
    If nums1[i - 1] == nums2[j - 1], then dp[i][j] = dp[i - 1][j - 1] + 1.
    If nums1[i - 1] != nums2[j - 1], then dp[i][j] = 0.

     */


    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        // Build the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        MaxLengthRepeatedSubarray solution = new MaxLengthRepeatedSubarray();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(solution.findLength(nums1, nums2)); // Output: 3

        // Test Case 2
        int[] nums3 = {0, 0, 0, 0, 0};
        int[] nums4 = {0, 0, 0, 0, 0};
        System.out.println(solution.findLength(nums3, nums4)); // Output: 5

        // Test Case 3
        int[] nums5 = {1, 2, 3, 4, 5};
        int[] nums6 = {5, 4, 3, 2, 1};
        System.out.println(solution.findLength(nums5, nums6)); // Output: 1
    }

}
