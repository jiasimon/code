package com.sjia.Leetcode;

import java.util.Arrays;

public class HouseRobber {
    // #198 https://leetcode.com/problems/house-robber/

    // DP, Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
    //Memory Usage: 38.8 MB, less than 5.09% of Java online submissions for House Robber.

    public int rob(int[] nums) {
        int q=0, z=0, result=0;
        for (int i=0; i<nums.length; i++ ) {
            result = Math.max(q + nums[i], z);
            q = z;
            z = result;
        }
        return result;
    }

    // Recursive Time Limit Exceeded
/*
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }
    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }*/


    public static void main(String[] args) {

        //int[] testData  = {0,0};
        int[] testData = {2, 7, 9, 3 ,1};

        HouseRobber solution = new HouseRobber();
        int result = solution.rob(testData);

        System.out.printf(" testData  %s , rob max is %s \n",Arrays.toString(testData), result);
    }

}
