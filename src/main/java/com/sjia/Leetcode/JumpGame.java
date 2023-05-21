package com.sjia.Leetcode;

public class JumpGame {
    // #55. Jump Game  https://leetcode.com/problems/jump-game/

    // You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
    // Return true if you can reach the last index, or false otherwise.

    // Input: nums = [2,3,1,1,4]  Output: true
    // Input: nums = [3,2,1,0,4]  Output: false

    // 1 <= nums.length <= 104
    // 0 <= nums[i] <= 105

    // from end to start, record lastPosition
    public static boolean canJump(int[] nums) {
        /* can comment out based on the condition
        if (nums == null || nums.length == 0) {
            return false;
        }
        */

        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }

        return lastPosition == 0;
    }



    // from start to end
    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for ( int i =0; i < n; i++) {
            farthest = Math.max(farthest, i+nums[i]);
            if (farthest < i+1) break;
        }
        if (farthest >= n-1) return true;
        else return false;
    }


    // loop compare to farthest
    public static boolean canJump3(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for ( int i =0; i <= farthest; i++) {
            farthest = Math.max(farthest, i+nums[i]);
            if (farthest >= n-1) return true;
        }
        return false;

    }



    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump? " + canJump3(nums1)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump? " + canJump3(nums2)); // Output: false
    }


}
