package com.sjia.Leetcode;

public class ArithmeticSlices {
    // #413. Arithmetic Slices  https://leetcode.com/problems/arithmetic-slices/description/

    /*
    An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

    For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
    Given an integer array nums, return the number of arithmetic subarrays of nums.

    A subarray is a contiguous subsequence of the array.

    Input: nums = [1,2,3,4]     Output: 3
    Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

    Input: nums = [1]           Output: 0

    input : [1,2,3] ans : 1
    input : [1,2,3,4] ans : 3
    input : [1,2,3,4,5] ans : 6
    input : [1,2,3,4,5,6] ans : 10
    input : [1,2,3,4,5,6,7] ans : 15
    input : [1,2,3,4,5,6,7,8] ans : 21
    input : [1,2,3,4,5,6,7,8,9] ans : 28

     */



    // DP, dp[i] = dp[i - 1] + 1
    // 0 ms, 100%; 41 MB, 7.46%
    public int numberOfArithmeticSlices_dp(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int[] dp = new int[n]; // dp[i] represents the number of arithmetic slices ending at index i
        int res = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i]; // Add the slices ending at i to the total count
            }
        }

        return res;
    }



    // dp, int[] to int
    // 0 ms, 100%; 40.7 MB, 24.37%
    public int numberOfArithmeticSlices_dp_space(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int tmp = 0;
        int res = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                tmp++;
                res += tmp; // Add the slices ending at i to the total count
            } else {
                tmp = 0;  // break continuous ,reset to 0
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ArithmeticSlices solution = new ArithmeticSlices();
        int[] A = {1, 2, 3, 4};
        int numSlices = solution.numberOfArithmeticSlices_dp(A);
        System.out.println("Number of arithmetic slices: " + numSlices);
    }

}
