package com.sjia.Leetcode;

public class IncreasingTripletSubsequence {
    // #334. Increasing Triplet Subsequence https://leetcode.com/problems/increasing-triplet-subsequence/
    /*
    Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

    Input: nums = [1,2,3,4,5]   Output: true    Explanation: Any triplet where i < j < k is valid.
    Input: nums = [5,4,3,2,1]   Output: false

    1 <= nums.length <= 5 * 10^5
    -2^31 <= nums[i] <= 2^31 - 1

     */

    // two pointer
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 2) return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.increasingTriplet(nums)); // Output: true (Increasing triplet subsequence: [1, 2, 3])




    }
}
