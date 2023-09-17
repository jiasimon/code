package com.sjia.Leetcode;

import java.util.*;

public class ArithmeticSlices2 {
    // #446. Arithmetic Slices II - Subsequence     https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/

    /*
    Given an integer array nums, return the number of all the arithmetic subsequences of nums.

    A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

    For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
    For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
    A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

    For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
    The test cases are generated so that the answer fits in 32-bit integer.

    Input: nums = [2,4,6,8,10]      Output: 7
    Input: nums = [7,7,7,7,7]       Output: 16
    1  <= nums.length <= 1000
    -2^31 <= nums[i] <= 2^31 - 1
     */


    // dp
    // 
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalSlices = 0; // Total count of arithmetic subsequences
        Map<Integer, Integer>[] dp = new HashMap[n]; // dp[i] stores subsequences ending at nums[i]

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j]; // Calculate the difference
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int diffInt = (int) diff; // Convert to int

                // Get the count of subsequences ending at nums[j] with the same difference
                int countJ = dp[j].getOrDefault(diffInt, 0);

                // Add the count of subsequences ending at nums[j] to dp[i] and totalSlices
                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + countJ + 1);
                totalSlices += countJ;
            }
        }

        return totalSlices;
    }



    public static void main(String[] args) {
        ArithmeticSlices2 solution = new ArithmeticSlices2();
        int[] nums = {2, 4, 6, 8, 10};

        int slices = solution.numberOfArithmeticSlices(nums);
        System.out.println("Number of Arithmetic Slices: " + slices); // Output: 7
    }



}
