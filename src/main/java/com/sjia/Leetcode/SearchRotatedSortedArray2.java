package com.sjia.Leetcode;

public class SearchRotatedSortedArray2 {
    //  #81. Search in Rotated Sorted Array II  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    //  compare to #33

    /*
    There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

    Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

    Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

    1 <= nums.length <= 5000
    -10^4 <= nums[i] <= 10^4
    nums is guaranteed to be rotated at some pivot.
    -10^4 <= target <= 10^4
     */

    // Input: nums = [2,5,6,0,0,1,2], target = 0  Output: true
    // Input: nums = [2,5,6,0,0,1,2], target = 3  Output: false

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle the case where left, right, and mid elements are the same
            // {10,10,10,10,10,10, 5,8,8,9,10}
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) { // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        boolean found = search(nums, target);

        System.out.println("Target exists: " + found); // Output: true

        int targetTwo = 3;
        boolean res = search(nums, targetTwo);
        System.out.println("Target exists: " + res); // Output: false

    }





}
