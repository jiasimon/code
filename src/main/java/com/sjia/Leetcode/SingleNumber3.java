package com.sjia.Leetcode;

public class SingleNumber3 {
    // #260. Single Number III  https://leetcode.com/problems/single-number-iii/
    /*
    Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
    Find the two elements that appear only once. You can return the answer in any order.

    You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
     */

    public int[] singleNumber(int[] nums) {


        return new int[]{1, 3};
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        SingleNumber3 solution = new SingleNumber3();
        int[] result = solution.singleNumber(nums);
        System.out.println("The two distinct numbers are: " + result[0] + " and " + result[1]);
        // Output: The two distinct numbers are: 3 and 5
    }
}
