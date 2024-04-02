package com.sjia.Leetcode;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    // #581. Shortest Unsorted Continuous Subarray  https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

    /*
    Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

    Return the shortest such subarray and output its length.

    Input: nums = [2,6,4,8,10,9,15]     Output: 5
    Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

    Input: nums = [1,2,3,4]     Output: 0

    Input: nums = [1]           Output: 0

    1 <= nums.length <= 10^4
    -10^5 <= nums[i] <= 10^5
     */

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int start = n, end = 0;
        for (int i = 0; i < n; i++) {
            if (sortedNums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start >= 0 ? end - start + 1 : 0;
    }


    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray solution = new ShortestUnsortedContinuousSubarray();

        int[] testArray = {2, 6, 4, 8, 10, 9, 15};

        System.out.println("Test Case 1: " + solution.findUnsortedSubarray(testArray)); // Output: 5
    }

}
