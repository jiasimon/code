package com.sjia.Leetcode;

import java.util.Arrays;

public class MaxProductThreeNum {
    // #628. Maximum Product of Three Numbers   https://leetcode.com/problems/maximum-product-of-three-numbers/description/
    /*
    Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

    Input: nums = [1,2,3]   Output: 6
    Input: nums = [1,2,3,4] Output: 24

    3 <= nums.length <= 10000
    -1000 <= nums[i] <= 1000
     */

    // sort
    // 11ms, 77.54%
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }



    // find min1 and min2; max1, max2, max3
    // 2ms, 98.99%
    public int maximumProduct_onepass(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }



    public static void main(String[] args) {
        MaxProductThreeNum solution = new MaxProductThreeNum();

        // Test Case
        int[] nums = {1, 2, 3, 4};
        System.out.println("Test Case 1: " + solution.maximumProduct(nums)); // Output: 24
    }

}
