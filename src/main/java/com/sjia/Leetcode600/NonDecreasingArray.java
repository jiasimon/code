package com.sjia.Leetcode600;

public class NonDecreasingArray {
    // #665. Non-decreasing Array   https://leetcode.com/problems/non-decreasing-array/description/
    /*
    Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

    We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

    Input: nums = [4,2,3]   Output: true
    Input: nums = [4,2,1]   Output: false

    1 <= n <= 10^4
    -10^5 <= nums[i] <= 10^5
     */

    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;

        int modificationCount = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (modificationCount++ > 0) {
                    return false;
                }
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i]; // Modify nums[i-1] to nums[i]
                } else {
                    nums[i] = nums[i - 1]; // Modify nums[i] to nums[i-1]
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArray solution = new NonDecreasingArray();

        // Test case 1
        int[] nums1 = {4, 2, 3};
        System.out.println("Test case 1: " + solution.checkPossibility(nums1));  // Expected output: true

        // Test case 2
        int[] nums2 = {4, 2, 1};
        System.out.println("Test case 2: " + solution.checkPossibility(nums2));  // Expected output: false

        // Test case 3
        int[] nums3 = {3, 4, 2, 3};
        System.out.println("Test case 3: " + solution.checkPossibility(nums3));  // Expected output: false

        // Test case 4
        int[] nums4 = {5, 7, 1, 8};
        System.out.println("Test case 4: " + solution.checkPossibility(nums4));  // Expected output: true

        // Test case 5
        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("Test case 5: " + solution.checkPossibility(nums5));  // Expected output: true
    }

}
