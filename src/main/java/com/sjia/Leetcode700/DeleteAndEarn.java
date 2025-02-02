package com.sjia.Leetcode700;

public class DeleteAndEarn {
    // #740. Delete and Earn   https://leetcode.com/problems/delete-and-earn/description/
    /*
Transform the problem into a House Robber Problem:

    Instead of deleting elements from the array, we convert it into a points system where picking a number x removes all occurrences of x-1 and x+1.
    Create an array points[], where points[i] represents the total sum of choosing the number i.

Use Dynamic Programming (DP):

    Define dp[i]: Maximum points that can be earned considering numbers 0 to i.
    Transition Formula:

dp[i] = max(dp[i - 1], dp[i - 2] + points[i])

This is identical to the House Robber problem.
     */

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] points = new int[maxVal + 1];

        // Calculate total points for each number
        for (int num : nums) {
            points[num] += num;
        }

        // Apply the House Robber DP
        int prev2 = 0, prev1 = 0;
        for (int i = 0; i <= maxVal; i++) {
            int curr = Math.max(prev1, prev2 + points[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        DeleteAndEarn solution = new DeleteAndEarn();

        // Test case 1
        int[] nums1 = {3, 4, 2};
        System.out.println(solution.deleteAndEarn(nums1)); // Expected Output: 6

        // Test case 2
        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println(solution.deleteAndEarn(nums2)); // Expected Output: 9

        // Test case 3
        int[] nums3 = {1, 1, 1, 2, 4, 5, 5, 5, 6};
        System.out.println(solution.deleteAndEarn(nums3)); // Expected Output: 18
    }
}
