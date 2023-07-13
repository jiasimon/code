package com.sjia.Leetcode;

import java.util.Arrays;

public class MaximumGap {
    // #164. Maximum Gap    https://leetcode.com/problems/maximum-gap/description/
    /*
    Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
    If the array contains less than two elements, return 0.

    write an algorithm that runs in linear time and uses linear extra space.
    Input: nums = [3,6,9,1]     Output: 3
    Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.

    Input: nums = [10]      Output: 0
    Explanation: The array contains less than 2 elements, therefore return 0.

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 10^9


     */



    public int maximumGapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i=1; i< nums.length; i++) {
            if (nums[i] - nums[i-1] > res) res = nums[i] - nums[i-1];
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumGap solution = new MaximumGap();

        // Test case 1
        int[] nums1 = {3, 6, 9, 1};
        int maxGap1 = solution.maximumGapSort(nums1);
        System.out.println("Maximum Gap Test Case 1: " + maxGap1);  // Expected output: 3

        // Test case 2
        int[] nums2 = {10};
        int maxGap2 = solution.maximumGapSort(nums2);
        System.out.println("Maximum Gap Test Case 2: " + maxGap2);  // Expected output: 0
    }


}
