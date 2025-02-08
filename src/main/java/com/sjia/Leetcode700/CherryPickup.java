package com.sjia.Leetcode700;

import java.util.Arrays;

public class CherryPickup {
    // #741. Cherry Pickup      https://leetcode.com/problems/cherry-pickup/description/
    /*

     */


    private int[][] grid;
    private int n;
    private int[][][] memo;

    // Time Limit Exceeded
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.memo = new int[n][n][n];

        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, dp(0, 0, 0));
    }

    private int dp(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;  // Since both move together, derive c2

        // Base case: out of bounds or obstacle
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        // If both reached bottom-right, return the cherry count
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        // If already computed, return the cached value
        if (memo[r1][c1][r2] != Integer.MIN_VALUE) {
            return memo[r1][c1][r2];
        }

        // Current cherries collected (avoid double-counting if r1 == r2 and c1 == c2)
        int cherries = grid[r1][c1];
        if (r1 != r2) {
            cherries += grid[r2][c2];
        }

        // Recursively explore all possible moves
        int maxNext = Math.max(
                Math.max(dp(r1 + 1, c1, r2 + 1), dp(r1 + 1, c1, r2)), // Person 1 down, Person 2 down or right
                Math.max(dp(r1, c1 + 1, r2 + 1), dp(r1, c1 + 1, r2))  // Person 1 right, Person 2 down or right
        );

        if (maxNext == Integer.MIN_VALUE) {
            return memo[r1][c1][r2] = Integer.MIN_VALUE;
        }

        // Store result in memo and return
        memo[r1][c1][r2] = cherries + maxNext;
        return memo[r1][c1][r2];
    }

    public static void main(String[] args) {
        CherryPickup solution = new CherryPickup();

        // Test case 1
        int[][] grid1 = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}
        };
        System.out.println(solution.cherryPickup(grid1)); // Expected Output: 5

        // Test case 2
        int[][] grid2 = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };
        System.out.println(solution.cherryPickup(grid2)); // Expected Output: 16

        // Test case 3 (Edge case: No path available)
        int[][] grid3 = {
                {1, -1},
                {-1, 1}
        };
        System.out.println(solution.cherryPickup(grid3)); // Expected Output: 0
    }



}
