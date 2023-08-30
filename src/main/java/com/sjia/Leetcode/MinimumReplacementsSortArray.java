package com.sjia.Leetcode;

import java.util.Arrays;

public class MinimumReplacementsSortArray {
    // #2366. Minimum Replacements to Sort the Array    https://leetcode.com/problems/minimum-replacements-to-sort-the-array/description/

    /*
    You are given a 0-indexed integer array nums. In one operation you can replace any element of the array with any two elements that sum to it.

    For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].
    Return the minimum number of operations to make an array that is sorted in non-decreasing order.

    Input: nums = [3,9,3]       Output: 2

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9

     */


    public long minimumReplacement(int[] nums) {
        long res = 0;

        int max = nums[nums.length - 1];

        // Start from the second last element, as the last one is always sorted.
        for (int i = nums.length - 2; i >= 0; --i) {
            // No need to break if they are already in order.
            if (nums[i] <= nums[i + 1]) {
                continue;
            }

            // Count how many elements are made from breaking nums[i]
            long numElements = (long)(nums[i] + nums[i + 1] - 1) / (long)nums[i + 1];

            // It requires numElements - 1 replacement operations.
            res += numElements -1;

            // Maximize nums[i] after replacement.
            nums[i] = nums[i] / (int)numElements;

        }
        return res;

    }

    public static void main(String[] args) {
        MinimumReplacementsSortArray solution = new MinimumReplacementsSortArray();
        int[] nums = {5, 6, 7};
        long minOperations = solution.minimumReplacement(nums);
        System.out.println("Minimum operations to sort the array: " + minOperations);

        int[] nums2 = {3, 9, 3};
        minOperations = solution.minimumReplacement(nums2);
        System.out.println("Minimum operations to sort the array: " + minOperations);
    }


}
