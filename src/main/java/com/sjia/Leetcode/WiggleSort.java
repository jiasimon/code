package com.sjia.Leetcode;

import java.util.Arrays;

public class WiggleSort {
    // #280. Wiggle Sort    https://leetcode.com/problems/wiggle-sort/  #premium
    /*
    Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
    Example:
    Input: nums = [3,5,2,1,6,4]
    Output: One possible answer is [3,5,1,6,2,4]

    #forinterview

    [1,2,3,4,5,6]
    [1,2,3,4,5,6]


     */



    // sort, swap odd even, from nums[1]
    // nums[0] <= nums[1] >= nums[2] <= nums[3]
    public void wiggleSort_sort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // nums[0] >= nums[1] <= nums[2] >= nums[3]
    public void wiggleSort_sort2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }



    //
    public void wiggleSort_swap(int[] nums) {
        // 1. if i is even, then nums[i] <= nums[i - 1]
        // 2. if i is odd, then nums[i] >= nums[i - 1]
        for (int i = 1; i < nums.length; ++i)
            if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1]))
                swap(nums, i, i - 1);
    }



    public static void main(String[] args) {
        WiggleSort solution = new WiggleSort();
        int[] nums = {3, 5, 2, 1, 6, 4};
        solution.wiggleSort_sort(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 3, 2, 5, 4, 6]

        solution.wiggleSort_sort2(nums);
        System.out.println(Arrays.toString(nums)); // Output: [2, 1, 4, 3, 6, 5], nums[0] >= nums[1] <= nums[2] >= nums[3]


        solution.wiggleSort_swap(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 4, 2, 6, 3, 5]




    }


}
