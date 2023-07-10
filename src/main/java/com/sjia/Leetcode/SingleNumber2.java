package com.sjia.Leetcode;

import java.util.Arrays;

public class SingleNumber2 {
    // #137. Single Number II   https://leetcode.com/problems/single-number-ii/description/
    /*
    Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
    Input: nums = [2,2,3,2] Output: 3
    Input: nums = [0,1,0,1,0,1,99]  Output: 99
    -2^31 <= nums[i] <= 2^31 - 1
    Each element in nums appears exactly three times except for one element which appears once.
     */


    // Sort
    // 4 ms, 62.67% ; 44.3 MB, 37.55%
    public int singleNumberSort(int[] nums) {
        Arrays.sort(nums);

        for (int i=2; i< nums.length; i+=3){
            if(nums[i] != nums[i-2]) {
                return nums[i-2];
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        SingleNumber2 solution = new SingleNumber2();

        // Test case
        int[] nums = {2, 2, 3, 2};
        int result = solution.singleNumberSort(nums);

        // Print the result
        System.out.println("Single Number: " + result);  // Output: 3
    }


}
