package com.sjia.Leetcode;

public class MinCostClimbingStairs {
    // #746 https://leetcode.com/problems/min-cost-climbing-stairs/
    // compare with #198 house robber

    // Input: cost = [10, 15, 20], output= 15
    // Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]  Output: 6
    // cost will have a length in the range [2, 1000].
    //Every cost[i] will be an integer in the range [0, 999].

    // Runtime: 1 ms, faster than 88.11% of Java online submissions for Min Cost Climbing Stairs.
    //Memory Usage: 41.6 MB, less than 5.01% of Java online submissions for Min Cost Climbing Stairs.
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] =cost[0];
        dp[1] = cost[1];
        for (int i=2; i< cost.length; i++ ) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[cost.length-1], dp[cost.length-2]);

    }



}
