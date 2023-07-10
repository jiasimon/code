package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumberInArray {

    // #136. Single Number  https://leetcode.com/problems/single-number/
    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.
    Input: nums = [2,2,1]   Output: 1
    Input: nums = [4,1,2,1,2]   Output: 4

     */

    // leetcode was down for some time today. Runtime: 6 ms, faster than 39.12% of Java online submissions for Single Number.
    //Memory Usage: 40.3 MB, less than 59.60% of Java online submissions for Single Number.
/*
    public int singleNumber(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (result.contains(num)) result.remove(num);
            else result.add(num);
        }
        return result.stream().findFirst().get();
    }*/


    //Runtime: 1 ms, faster than 73.39% of Java online submissions for Single Number.
    //Memory Usage: 43.6 MB, less than 5.10% of Java online submissions for Single Number.

    public int singleNumber(int[] nums) {
        int result =0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


    // sort, 6 ms, 42.20%; 44.7 MB, 49.4%
    public int singleNumberSort(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i< nums.length; i+=2){
            if(nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }


    public static void main(String[] args) {

        int[] testData  = {7,1,7,1,6};
        //int[] testData  = {7,6,4,3,1};
        SingleNumberInArray solution = new SingleNumberInArray();

        int result = solution.singleNumber(testData);

        System.out.printf("BuySellStock multi time, testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }

}
