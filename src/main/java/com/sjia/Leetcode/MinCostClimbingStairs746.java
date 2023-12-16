package com.sjia.Leetcode;

public class MinCostClimbingStairs746 {
    // #746. Min Cost Climbing Stairs   https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=daily-question&envId=2023-12-17

    /*
    You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

    You can either start from the step with index 0, or the step with index 1.

    Return the minimum cost to reach the top of the floor.
     */


    // recursive,  TLE 259 / 283
    public int minCostClimbingStairs_recursive(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }
    private int minCost(int[] cost, int n) {
        if (n < 0) return 0;
        if (n==0 || n==1) return cost[n];
        return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }




    public static void main(String[] args) {
        MinCostClimbingStairs746 solution = new MinCostClimbingStairs746();

        int[] cost = {10, 15, 20};

        int minCost = solution.minCostClimbingStairs_recursive(cost);
        System.out.println("Minimum cost to reach the top of the stairs: " + minCost);
    }
}
