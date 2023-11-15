package com.sjia.Leetcode;

public class MaximumSumKElements {
    // #2656. Maximum Sum With Exactly K Elements   https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/description/

    /*
    You are given a 0-indexed integer array nums and an integer k. Your task is to perform the following operation exactly k times in order to maximize your score:

    Select an element m from nums.
    Remove the selected element m from the array.
    Add a new element with a value of m + 1 to the array.
    Increase your score by m.
    Return the maximum score you can achieve after performing the operation exactly k times.

    Input: nums = [1,2,3,4,5], k = 3    Output: 18
    Input: nums = [5,5,5], k = 2        Output: 11
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
    1 <= k <= 100
     */


    //
    // 1 ms, 100%; 44.1 MB, 15.7%
    public int maximizeSum(int[] nums, int k) {
        int tmp = 0;
        for ( int n : nums) {
            tmp = Math.max(tmp, n);
        }
        return tmp * k + k *( k-1)/2 ;

    }

    public static void main(String[] args) {
        MaximumSumKElements solution = new MaximumSumKElements();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;

        int result = solution.maximizeSum(nums, 3);
        System.out.println("Maximum Element: " + result);  // 18
    }



}
