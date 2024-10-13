package com.sjia.Leetcode700;

public class BinarySearch {
    // #704. Binary Search  https://leetcode.com/problems/binary-search/description/
    /*
    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    Input: nums = [-1,0,3,5,9,12], target = 9   Output: 4
     */

    // left <= right
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Avoid potential overflow
            if (nums[mid] == target) {
                return mid;  // Target found
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search the right half
            } else {
                right = mid - 1;  // Search the left half
            }
        }
        return -1;  // Target not found
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();

        // Test Case 1: Target is present in the array
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Index of 9: " + solution.search(nums1, target1));  // Output: 4

        // Test Case 2: Target is not present in the array
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println("Index of 2: " + solution.search(nums2, target2));  // Output: -1

        // Test Case 3: Single element, target present
        int[] nums3 = {5};
        int target3 = 5;
        System.out.println("Index of 5: " + solution.search(nums3, target3));  // Output: 0

        // Test Case 4: Single element, target not present
        int[] nums4 = {5};
        int target4 = 1;
        System.out.println("Index of 1: " + solution.search(nums4, target4));  // Output: -1
    }
}
