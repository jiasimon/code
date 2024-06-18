package com.sjia.Leetcode600;

public class NumberLongestIncreasingSubsequence {
    // #673. Number of Longest Increasing Subsequence   https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
    /*
    Given an integer array nums, return the number of longest increasing subsequences.

    Notice that the sequence has to be strictly increasing.

    Input: nums = [1,3,5,4,7]   Output: 2
    Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

    Input: nums = [2,2,2,2,2]   Output: 5
    Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.

    1 <= nums.length <= 2000
    -10^6 <= nums[i] <= 10^6
     */

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] lengths = new int[n]; // lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[n];  // counts[i] = number of longest ending in nums[i]

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            lengths[i] = 1;
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }

        int numberOfLIS = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                numberOfLIS += counts[i];
            }
        }

        return numberOfLIS;
    }

    public static void main(String[] args) {
        NumberLongestIncreasingSubsequence solution = new NumberLongestIncreasingSubsequence();

        // Test case 1
        int[] nums1 = {1, 3, 5, 4, 7};
        System.out.println("Test case 1: " + solution.findNumberOfLIS(nums1)); // Expected output: 2

        // Test case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println("Test case 2: " + solution.findNumberOfLIS(nums2)); // Expected output: 5

        // Test case 3
        int[] nums3 = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println("Test case 3: " + solution.findNumberOfLIS(nums3)); // Expected output: 3

        // Test case 4
        int[] nums4 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println("Test case 4: " + solution.findNumberOfLIS(nums4)); // Expected output: 1

        // Test case 5
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Test case 5: " + solution.findNumberOfLIS(nums5)); // Expected output: 1
    }


}
