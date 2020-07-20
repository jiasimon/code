package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class MaximumSubarray {

    // #53 https://leetcode.com/problems/maximum-subarray/

    // Runtime: 2 ms, faster than 17.21% of Java online submissions for Maximum Subarray.
    //Memory Usage: 41.7 MB, less than 5.39% of Java online submissions for Maximum Subarray.
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


    public static void main(String[] args) {

        //int[] testData = {1, 1, 2, 4 ,8 ,10};
        int[] testData  = {-2,1,-3,4,-1,2,1,-5,4};


        MaximumSubarray solution = new MaximumSubarray();
        int result = solution.maxSubArray(testData);
        System.out.printf(" testData %s MaximumSubarray is %s \n", Arrays.toString(testData), result);
    }


}
