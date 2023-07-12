package com.sjia.Leetcode;

public class MaximumProductSubarray {
    // #152. Maximum Product Subarray   https://leetcode.com/problems/maximum-product-subarray/
    /*
    Given an integer array nums, find a subarray that has the largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
    1 <= nums.length <= 2 * 104
    -10 <= nums[i] <= 10
    Input: nums = [2,3,-2,4]    Output: 6
    Input: nums = [-2,0,-1]     Output: 0

     */

    // swap min, max when n[i] < 0,
    // 1 ms, 85.86%; 43.5 MB, 54.89%
    public int maxProduct(int[] nums) {
        // Initialize variables to store the maximum and minimum product
        int max = nums[0];
        int min = nums[0];
        int result = max;

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            // If the current number is negative, swap the maximum and minimum product
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            // Update the maximum and minimum product by considering the current number
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            // Update the overall maximum product
            result = Math.max(result, max);
        }

        return result;
    }

}
