package com.sjia.Leetcode;

import java.util.Arrays;

public class MoveZeroes {

    // #283. Move Zeroes https://leetcode.com/problems/move-zeroes/

    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.
    Input: nums = [0,1,0,3,12]  Output: [1,3,12,0,0]
    Input: nums = [0]       Output: [0]

     */


    // insert non-zero, two pass
    public void moveZeroesByInsert(int[] nums) {
        if (nums == null || nums.length ==0 ) return;

        int p=0;
        for (int i=0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }

        for ( int i=p; i < nums.length; i++ ) {
            nums[i] = 0;
        }

    }


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    //Memory Usage: 40 MB, less than 13.86% of Java online submissions for Move Zeroes.
/*
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length ==1) return;
        int j=0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }*/


    // Snowball
    public void moveZeroesSnowball(int[] nums) {
        int snowball = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                snowball++;
            }
            else if (snowball > 0) {
                int t = nums[i];
                nums[i]=0;
                nums[i-snowball]=t;
            }
        }
    }


    public static void main(String[] args) {
         int[] testData = { 0,1,0,3,12 };
//        int[] testData = { 1,2,3,0,12 };
        MoveZeroes solution = new MoveZeroes();
        solution.moveZeroesSnowball(testData);
        System.out.println("The result is: " + Arrays.toString(testData));

    }


}
