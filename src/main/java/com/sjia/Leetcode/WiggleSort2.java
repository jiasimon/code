package com.sjia.Leetcode;

import java.util.Arrays;

public class WiggleSort2 {
    // #324. Wiggle Sort II https://leetcode.com/problems/wiggle-sort-ii/
    /*
    Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

    You may assume the input array always has a valid answer.

    Input: nums = [1,5,1,1,6,4]     Output: [1,6,1,5,1,4]
    Explanation: [1,4,1,5,1,6] is also accepted.

    Input: nums = [1,3,2,2,3,1]     Output: [2,3,1,3,1,2]

    1 <= nums.length <= 5 * 10^4    0 <= nums[i] <= 5000
    It is guaranteed that there will be an answer for the given input nums.

    Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?

     */


    // sort, odd, even put num from big to small
    // 6ms, 35.27%; 46.65mb, 84.23%
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int[] tmp = new int[nums.length];
        int j = nums.length - 1;
        for (int i=1; i < nums.length; i=i+2) {
            tmp[i] = nums[j];
            j--;
        }

        for (int i=0; i < nums.length; i=i+2) {
            tmp[i] = nums[j];
            j--;
        }

        for (int i=0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }


    }


    public static void main(String[] args) {
        WiggleSort2 solution = new WiggleSort2();
        int[] nums = {1, 5, 1, 1, 6, 4};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 6, 1, 5, 1, 4]

        int[] nums2 = {1, 2, 4, 4, 4, 6};
        solution.wiggleSort(nums2);
        System.out.println(Arrays.toString(nums2)); // Output: [4, 6, 2, 4, 1, 4]

    }

}
