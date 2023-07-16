package com.sjia.Leetcode;

import java.util.Arrays;

public class RotateArray {

    // #189. Rotate Array https://leetcode.com/problems/rotate-array/
    /*
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
    Input: nums = [1,2,3,4,5,6,7], k = 3    Output: [5,6,7,1,2,3,4]
    Input: nums = [-1,-100,3,99], k = 2     Output: [3,99,-1,-100]


     */

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



    // tmp[(i+k) % length]
    // 1 ms, 50.88%; 55.2 MB, 88.54%
    public void rotateStep(int[] nums, int k) {
        int length = nums.length;
        int[] tmp = new int[length];
        int step = k % length;

        for (int i=0; i < length; i++ ) {
            tmp[(i+step) % length] = nums[i];
        }
        for (int i=0; i < length; i++ ) {
            nums[i] = tmp[i];
        }
    }

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
