package com.sjia.Leetcode;

import java.util.Arrays;

public class RotateArray {

    // #189 https://leetcode.com/problems/rotate-array/

    // Runtime: 1 ms, faster than 53.97% of Java online submissions for Rotate Array.
    //Memory Usage: 43 MB, less than 5.08% of Java online submissions for Rotate Array.

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int result[] = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            result[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {

        //int[] testData  = {0,0};
        int[] testData  = {3,30,34,5,9};
        int step = 2;

        RotateArray solution = new RotateArray();
        solution.rotate(testData, step);

        System.out.printf(" testData rotate %s is %s \n", step, Arrays.toString(testData));
    }

}
