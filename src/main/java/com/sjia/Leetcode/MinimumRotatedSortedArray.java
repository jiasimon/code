package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class MinimumRotatedSortedArray {
    // #153. Find Minimum in Rotated Sorted Array   https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    /*
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

    Given the sorted rotated array nums of unique elements, return the minimum element of this array.

    You must write an algorithm that runs in O(log n) time.
    Input: nums = [3,4,5,1,2]       Output: 1
    Input: nums = [4,5,6,7,0,1,2]   Output: 0
    Input: nums = [11,13,15,17]     Output: 11
     */

    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            int mid = (left + right) /2;
            if (nums[mid] > nums[right]) {
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return nums[left];

    }

    public static void main(String[] args) {
        MinimumRotatedSortedArray solution = new MinimumRotatedSortedArray();

        // Test case
        int[] test1 = {5,6,2,3,4};

        int result = solution.findMin(test1);

        // Print the result
        System.out.println(" test1 input: " + test1 + " , result: "  + result);  // Output: 2


    }



}
