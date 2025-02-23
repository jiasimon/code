package com.sjia.Leetcode700;

public class MinCostClimbingStairs {
    // #746. Min Cost Climbing Stairs   https://leetcode.com/problems/min-cost-climbing-stairs/description/
    /*
    2 <= cost.length <= 1000

    Input: cost = [10,15,20]    Output: 15
    Input: cost = [1,100,1,1,1,100,1,1,100,1]   Output: 6

    Define the State

        Let dp[i] represent the minimum cost to reach step i.

    Recurrence Relation

        From any step i, we can reach i+1 or i+2, so:
        dp[i]=cost[i]+min⁡(dp[i−1],dp[i−2])
        dp[i]=cost[i]+min(dp[i−1],dp[i−2])

    Base Cases

        dp[0] = cost[0]
        dp[1] = cost[1]
     */

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) return Math.min(cost[0], cost[1]);

        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }

        return Math.min(first, second);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs sol = new MinCostClimbingStairs();

        int[] cost1 = {10, 15, 20};
        System.out.println(sol.minCostClimbingStairs(cost1)); // Output: 15

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(sol.minCostClimbingStairs(cost2)); // Output: 6
    }


}
