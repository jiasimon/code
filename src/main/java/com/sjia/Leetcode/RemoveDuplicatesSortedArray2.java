package com.sjia.Leetcode;

public class RemoveDuplicatesSortedArray2 {
    // #80. Remove Duplicates from Sorted Array II  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

    /*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
     */

    // Input: nums = [1,1,1,2,2,3]  Output: 5, nums = [1,1,2,2,3,_]
    // Input: nums = [0,0,1,1,1,1,2,3,3] Output: 7, nums = [0,0,1,1,2,3,3,_,_]

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 2; // Pointer to track the current position to insert a new element

        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    //
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2]) {
                nums[i] = n;
                i++;
            }

        return i;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int newLength = removeDuplicates2(nums);

        System.out.println("New length: " + newLength); // Output: 5
        System.out.print("Updated array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " "); // Output: 1 1 2 2 3
        }
    }

}
