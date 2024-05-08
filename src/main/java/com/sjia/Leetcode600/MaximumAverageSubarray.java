package com.sjia.Leetcode600;

public class MaximumAverageSubarray {
    // #643. Maximum Average Subarray I     https://leetcode.com/problems/maximum-average-subarray-i/description/
    /*
    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

    Input: nums = [1,12,-5,-6,50,3], k = 4  Output: 12.75000
    Input: nums = [5], k = 1    Output: 5.00000

    1 <= k <= n <= 10^5
    -10^4 <= nums[i] <= 10^4
     */


    // sum of slide window
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray solution = new MaximumAverageSubarray();

        // Test Case
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("Test Case 1: " + solution.findMaxAverage(nums, k)); // Output: 12.75
    }

}
