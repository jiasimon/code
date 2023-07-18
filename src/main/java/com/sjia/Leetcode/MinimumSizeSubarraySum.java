package com.sjia.Leetcode;

public class MinimumSizeSubarraySum {
    // #209. Minimum Size Subarray Sum  https://leetcode.com/problems/minimum-size-subarray-sum/
    /*
    Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
    whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

    Input: target = 7, nums = [2,3,1,2,4,3]     Output: 2
    Input: target = 4, nums = [1,4,4]       Output: 1
    Input: target = 11, nums = [1,1,1,1,1,1,1,1]    Output: 0

     */


    // Brute force, two loop, TLE
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if( n==0) return 0;

        int res = Integer.MAX_VALUE;
        for ( int i =0; i < n; i++){
            int sum =0;   // reset to 0 after
            for (int j=i; j < n ; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    res = Math.min(res, j-i+1);
                    break;
                }
            }
        }
        if (res == Integer.MAX_VALUE) return 0;
        else return res;
    }

    // Test the code
    public static void main(String[] args) {
        // Test Case 1: 2
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int result1 = minSubArrayLen(target1, nums1);
        System.out.println("Minimum size subarray length: " + result1);

        // Test Case 2: 2
        int target2 = 15;
        int[] nums2 = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int result2 = minSubArrayLen(target2, nums2);
        System.out.println("Minimum size subarray length: " + result2);

        // Test Case 3: No subarray with sum >= 20, should return 0
        int target3 = 20;
        int[] nums3 = {1, 2, 3, 4, 5};
        int result3 = minSubArrayLen(target3, nums3);
        System.out.println("Minimum size subarray length: " + result3);
    }



}
