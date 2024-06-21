package com.sjia.Leetcode600;

public class LongestContinuousIncreasingSubseq {
    // #674. Longest Continuous Increasing Subsequence  https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
    /*
    Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasin

    Input: nums = [1,3,5,4,7]       Output: 3
     */

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubseq solution = new LongestContinuousIncreasingSubseq();

        // Test case 1
        int[] nums1 = {1, 3, 5, 4, 7};
        System.out.println("Test case 1: " + solution.findLengthOfLCIS(nums1)); // Expected output: 3

        // Test case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println("Test case 2: " + solution.findLengthOfLCIS(nums2)); // Expected output: 1

        // Test case 3
        int[] nums3 = {1, 3, 5, 7};
        System.out.println("Test case 3: " + solution.findLengthOfLCIS(nums3)); // Expected output: 4

        // Test case 4
        int[] nums4 = {5, 4, 3, 2, 1};
        System.out.println("Test case 4: " + solution.findLengthOfLCIS(nums4)); // Expected output: 1

        // Test case 5
        int[] nums5 = {1, 2, 2, 3, 4, 5, 1, 2, 3};
        System.out.println("Test case 5: " + solution.findLengthOfLCIS(nums5)); // Expected output: 4
    }
}
