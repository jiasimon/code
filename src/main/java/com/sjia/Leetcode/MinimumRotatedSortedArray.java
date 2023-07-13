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


    // two pointers
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated, return the first element
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        // Perform binary search to find the minimum element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if the mid element is greater than its next element
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Check if the mid element is smaller than its previous element
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // If the mid element is greater than the leftmost element,
            // the minimum element is on the right side of the mid
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            }
            // Otherwise, the minimum element is on the left side of the mid
            else {
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
