package com.sjia.Leetcode;

import java.util.Arrays;

public class RotateArray {

    // #189 https://leetcode.com/problems/rotate-array/

    // Runtime: 1 ms, faster than 53.97% of Java online submissions for Rotate Array.
    //Memory Usage: 43 MB, less than 5.08% of Java online submissions for Rotate Array.
/*
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int result[] = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            result[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }*/


    // three reverse, Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
    //Memory Usage: 39.9 MB, less than 53.45% of Java online submissions for Rotate Array.

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);

    }


    public void reverseArray(int[] nums, int left, int right) {
        int tmp;
        while (left < right) {
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {

        //int[] testData  = {0,0};
        int[] testData = {3, 30, 34, 5, 9}; // 5, 9, 3, 30, 34
        int step = 2;

        RotateArray solution = new RotateArray();
        solution.rotate(testData, step);

        System.out.printf(" testData rotate %s is %s \n", step, Arrays.toString(testData));
    }

}
