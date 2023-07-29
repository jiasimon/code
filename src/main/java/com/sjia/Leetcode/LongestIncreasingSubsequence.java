package com.sjia.Leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // #300. Longest Increasing Subsequence https://leetcode.com/problems/longest-increasing-subsequence/
    /*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    Input: nums = [10,9,2,5,3,7,101,18]     Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    Input: nums = [0,1,0,3,2,3]     Output: 4
    Input: nums = [7,7,7,7,7,7,7]   Output: 1

     */

    public int lengthOfLIS(int[] nums) {
        int res = 1;


        return res;
    }

    // Brute Force, TLE
    public int lengthOfLIS_Brute(int[] nums) {
        return helperLIS(nums, -1, 0);
    }

    public int helperLIS(int[] nums, int prev, int i) {
        if(i >= nums.length) return 0;

        int takeCurrent = 0;
        int notTakeCurrent = helperLIS(nums, prev, i+1);
        if (prev == -1 || nums[i] > nums[prev]) {
            takeCurrent = 1 + helperLIS(nums, i, i+1);
        }
        return Math.max(takeCurrent, notTakeCurrent);

    }


    //  memo
    // 343ms, 15.89%; 99.63mb, 6.89%
    public int lengthOfLIS_Memo(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for(int[] row: memo) Arrays.fill(row,-1); // remember to set default as -1, default 0 did not work
        return helperLIS_Memo(nums, -1, 0,  memo);
    }

    public int helperLIS_Memo(int[] nums, int prev, int i, int[][] memo) {
        if(i >= nums.length) return 0;

        if(prev != -1 && memo[prev][i] != -1) {
            return memo[prev][i];
        }

        int takeCurrent = 0;
        int notTakeCurrent = helperLIS_Memo(nums, prev, i+1, memo);
        if (prev == -1 || nums[i] > nums[prev]) {
            takeCurrent = 1 + helperLIS_Memo(nums, i, i+1, memo);
        }
        if(prev != -1) memo[prev][i] = Math.max(takeCurrent, notTakeCurrent);
        return Math.max(takeCurrent, notTakeCurrent);
    }




    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int result = solution.lengthOfLIS_Brute(nums);
        System.out.println("The length of the longest increasing subsequence is: " + result); // Output: The length of the longest increasing subsequence is: 4

        result = solution.lengthOfLIS_Memo(nums);
        System.out.println("lengthOfLIS_Memo: The length of the longest increasing subsequence is: " + result);
    }

}
