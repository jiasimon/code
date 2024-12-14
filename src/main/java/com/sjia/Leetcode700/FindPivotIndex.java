package com.sjia.Leetcode700;

public class FindPivotIndex {
    // #724. Find Pivot Index   https://leetcode.com/problems/find-pivot-index/description/
    /*
    Input: nums = [1,7,3,6,5,6]     Output: 3
    Input: nums = [1,2,3]           Output: -1
     */

    public int pivotIndex(int[] nums) {
        int leftSum=0;
        int total = 0;
        for (int num: nums){
            total += num;
        }

        for (int i =0; i< nums.length; i++) {
            if (leftSum *2 == total - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex solution = new FindPivotIndex();

        // Test Case 1
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(solution.pivotIndex(nums1)); // Output: 3

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        System.out.println(solution.pivotIndex(nums2)); // Output: -1

        // Test Case 3
        int[] nums3 = {2, 1, -1};
        System.out.println(solution.pivotIndex(nums3)); // Output: 0

        // Test Case 4
        int[] nums4 = {0, 0, 0, 1, 0};
        System.out.println(solution.pivotIndex(nums4)); // Output: 3
    }
}
