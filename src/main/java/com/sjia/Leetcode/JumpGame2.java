package com.sjia.Leetcode;

public class JumpGame2 {
    // #45. Jump Game II  https://leetcode.com/problems/jump-game-ii/
    /*
        You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
        Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
        0 <= j <= nums[i] and
        i + j < n
        Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
    */

    // Input: nums = [2,3,1,1,4] Output: 2
    // Input: nums = [2,3,0,1,4] Output: 2
    // 1 <= nums.length <= 104
    // 0 <= nums[i] <= 1000
    // It's guaranteed that you can reach nums[n - 1].


    // Greedy
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int jumps = 0;
        int currentPosition = 0; // farthest index that can be reached with the current number of jumps
        int maxReach = 0;  // farthest index that can be reached from the current index

        // i < nums.length - 1  instead of i < nums.length
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentPosition) {
                jumps++;
                currentPosition = maxReach;
            }
        }

        return jumps;
    }



    public static int jump2(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int res = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                res++;
                curEnd = curFar;
            }
        }

        return res;

    }


    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps: " + jump2(nums1)); // Output: 2

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Minimum jumps: " + jump2(nums2)); // Output: -1

        int[] nums3 = {2,3,0,1,4};
        System.out.println("Minimum jumps: " + jump2(nums3)); // Output: 2
    }





}
