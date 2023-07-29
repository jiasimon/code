package com.sjia.Leetcode;

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

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int result = solution.lengthOfLIS(nums);
        System.out.println("The length of the longest increasing subsequence is: " + result); // Output: The length of the longest increasing subsequence is: 4
    }

}
