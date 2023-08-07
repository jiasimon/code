package com.sjia.Leetcode;

public class PaintHouse {
    // #256. Paint House https://leetcode.com/problems/paint-house/

    /*
     There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
     The cost of painting each house with a certain color is different.
     You have to paint all the houses such that no two adjacent houses have the same color.

     Input: [[17,2,17],[16,16,5],[14,3,19]]     Output: 10
     */




    // DP
    public static int getMinimumPrice(int[][] cost) {
        int result = 0;

        for (int i = 1; i < cost.length; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][1], cost[i - 1][0]);
        }

//        result = Math.min(Math.min(cost[cost.length - 1][0], cost[cost.length - 1][1]), cost[cost.length - 1][2]);
        int tmp = Math.min(cost[cost.length - 1][0], cost[cost.length - 1][1] );
        result = Math.min(tmp,  cost[cost.length - 1][2] );
        return result;
    }

    public static void main(String args[]) {
        int[][] cost = {
                {17, 2, 1}, {16, 16, 1}, {14, 3, 19}, {3, 1, 8}
        };
        int minCost = getMinimumPrice(cost);
        System.out.println(minCost);

    }
}
