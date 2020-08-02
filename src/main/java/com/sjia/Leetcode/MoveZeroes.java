package com.sjia.Leetcode;

import java.util.Arrays;

public class MoveZeroes {

    // #283 https://leetcode.com/problems/move-zeroes/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    //Memory Usage: 39.5 MB, less than 84.61% of Java online submissions for Move Zeroes.
/*
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length ==1) return;
        int p=0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p]=nums[i];
                p++;
            }
        }
        for (int i=p; i<nums.length; i++) {
            nums[i]=0;
        }
    }*/


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

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    //Memory Usage: 39.3 MB, less than 97.15% of Java online submissions for Move Zeroes.

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


    public static void main(String[] args) {
        // int[] testData = { 0,1,0,3,12 };
        int[] testData = { 1,2,3,0,12 };
        MoveZeroes solution = new MoveZeroes();
        solution.moveZeroes(testData);
        System.out.println("The result is: " + Arrays.toString(testData));

    }


}
