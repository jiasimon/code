package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class MaximumSubarray {

    // #53. Maximum Subarray https://leetcode.com/problems/maximum-subarray/

    // Input: nums = [-2,1,-3,4,-1,2,1,-5,4]  Output: 6
    // 1 <= nums.length <= 10^5, -10^4 <= nums[i] <= 10^4



/*
    public int maxSubArray(int[] nums) {
        int result = nums[0] , sum = 0;
        for (int num : nums) {
            sum = Math.max(sum+ num, num);
            result = Math.max(result, sum);
        }
        return result;
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
    //Memory Usage: 40 MB, less than 11.38% of Java online submissions for Maximum Subarray.

    public int maxSubArray(int[] nums) {
        int result = nums[0] , sum = 0;
        for (int i = 0 ; i< nums.length; i++) {
            sum = Math.max(sum+ nums[i], nums[i]);
            result = Math.max(result, sum);
        }
        return result;
    }


    // brutal force
    public static int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        // Iterate through all possible subarrays
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {

        int[] testData = {-1, 1, 2, 4 ,-5 ,10};
//        int[] testData  = {-2,1,-3,4,-1,2,1,-5,4};


        MaximumSubarray solution = new MaximumSubarray();
        int result = solution.maxSubArray2(testData);
        System.out.printf(" testData %s MaximumSubarray is %s \n", Arrays.toString(testData), result);
    }


}
