package com.sjia.Leetcode700;

import java.util.Arrays;

public class CherryPickup {
    // #741. Cherry Pickup      https://leetcode.com/problems/cherry-pickup/description/
    /*

     */


    int[][][] memo;
    int[][] grid;
    int N;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        memo = new int[N][N][N];
        for (int[][] layer: memo) {
            for (int[] row: layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(0, 0, 0));
    }

    public int dp(int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (N == r1 || N == r2 || N == c1 || N == c2 ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -999999;
        } else if (r1 == N - 1 && c1 == N - 1) {
            return grid[r1][c1];
        } else if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
            return memo[r1][c1][c2];
        } else {
            int ans = grid[r1][c1];
            if (c1 != c2) {
                ans += grid[r2][c2];
            }
            ans += Math.max(Math.max(dp(r1, c1 + 1, c2 + 1), dp(r1 + 1, c1, c2 + 1)),
                    Math.max(dp(r1, c1 + 1, c2), dp(r1 + 1, c1, c2)));
            memo[r1][c1][c2] = ans;
            return ans;
        }
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
