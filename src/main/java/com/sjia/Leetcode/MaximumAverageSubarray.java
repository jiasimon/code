package com.sjia.Leetcode;

import java.util.Arrays;

public class MaximumAverageSubarray {
    // #643 https://leetcode.com/problems/maximum-average-subarray-i/


    // Runtime: 2 ms, faster than 96.64% of Java online submissions for Maximum Average Subarray I.
    //Memory Usage: 43.3 MB, less than 59.05% of Java online submissions for Maximum Average Subarray I.
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i< k; i++) {
            sum += nums[i];
        }
        int result =sum;

        for(int i = k; i< nums.length; i++) {
             sum +=  nums[i] - nums[i-k];
            result = Math.max(result, sum);
        }

        return result * 1.0 / k ;

    }



    public static void main(String[] args) {
        int[] testData  = {4,2,1,3,3};
        //int[] testData  = {1,12,-5,-6,50,3};
        int k = 2;
        MaximumAverageSubarray solution = new MaximumAverageSubarray();
        double result = solution.findMaxAverage(testData, k);
        System.out.printf("array %s  in %s contain duplicate : %s", Arrays.toString(testData), k, result);

    }


}
