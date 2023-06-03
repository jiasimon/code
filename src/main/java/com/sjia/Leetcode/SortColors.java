package com.sjia.Leetcode;

import java.util.Arrays;

public class SortColors {
    // #75. Sort Colors  https://leetcode.com/problems/sort-colors/
    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.
     */

    // Input: nums = [2,0,2,1,1,0]  Output: [0,0,1,1,2,2]


    // 3-way partitioning, Dutch National Flag
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println("Original array: " + Arrays.toString(nums));
        sortColors(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));
    }


}
