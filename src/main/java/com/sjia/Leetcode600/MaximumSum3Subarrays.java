package com.sjia.Leetcode600;

public class MaximumSum3Subarrays {
    // #689. Maximum Sum of 3 Non-Overlapping Subarrays     https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
    /*
    Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.
    Return the result as a list of indices representing the starting position of each interval (0-indexed)

    Input: nums = [1,2,1,2,6,7,5,1], k = 2  Output: [0,3,5]
    Input: nums = [1,2,1,2,1,2,1,2,1], k = 2    Output: [0,2,4]
     */


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1]; // Cumulative sum
        int[] left = new int[n];     // Best subarray index from the left
        int[] right = new int[n];    // Best subarray index from the right
        int[] result = new int[3];

        // Calculate cumulative sum
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        // Compute the best subarray index from the left for each position
        int bestLeft = 0;
        for (int i = k - 1; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > sum[bestLeft + k] - sum[bestLeft]) {
                bestLeft = i + 1 - k;
            }
            left[i] = bestLeft;
        }

        // Compute the best subarray index from the right for each position
        int bestRight = n - k;
        for (int i = n - k; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= sum[bestRight + k] - sum[bestRight]) {
                bestRight = i;
            }
            right[i] = bestRight;
        }

        // Find the maximum sum by trying the middle subarray and checking the left and right best subarrays
        int maxSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int totalSum = (sum[l + k] - sum[l]) + (sum[i + k] - sum[i]) + (sum[r + k] - sum[r]);
            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        MaximumSum3Subarrays solution = new MaximumSum3Subarrays();

        // Test Case 1
        int[] nums1 = {1, 2, 1, 2, 6, 7, 5, 1};
        int k1 = 2;
        int[] result1 = solution.maxSumOfThreeSubarrays(nums1, k1);
        System.out.println("Test Case 1: [" + result1[0] + ", " + result1[1] + ", " + result1[2] + "]"); // Expected output: [0, 3, 5]

        // Test Case 2
        int[] nums2 = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        int k2 = 2;
        int[] result2 = solution.maxSumOfThreeSubarrays(nums2, k2);
        System.out.println("Test Case 2: [" + result2[0] + ", " + result2[1] + ", " + result2[2] + "]"); // Expected output: [0, 2, 4]

        // Test Case 3
        int[] nums3 = {4, 3, 2, 5, 8, 7, 6, 1, 2};
        int k3 = 3;
        int[] result3 = solution.maxSumOfThreeSubarrays(nums3, k3);
        System.out.println("Test Case 3: [" + result3[0] + ", " + result3[1] + ", " + result3[2] + "]"); // Expected output: [0, 3, 6]
    }



}
