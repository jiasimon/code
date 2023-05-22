package com.sjia.Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGame6 {
    // #1696. Jump Game VI  https://leetcode.com/problems/jump-game-vi/

    /*
    0-indexed integer array nums and an integer k.

    You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

    You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

    Return the maximum score you can get.
     */

    // Input: nums = [1,-1,-2,4,-7,3], k = 2  Output: 7
    // Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.



    public static int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);

        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            dp[i] = nums[i] + dp[deque.peekFirst()];

            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, -1, -2, 4, -7, 3};
        int k1 = 2;
        System.out.println("Maximum result: " + maxResult(nums1, k1)); // Output: 7

        int[] nums2 = {10, -5, -2, 4, 0, 3};
        int k2 = 3;
        System.out.println("Maximum result: " + maxResult(nums2, k2)); // Output: 17

        int[] nums3 = {1, -5, -20, 4, -1, 3, -6, -3};
        int k3 = 2;
        System.out.println("Maximum result: " + maxResult(nums3, k3)); // Output: 0
    }


}
