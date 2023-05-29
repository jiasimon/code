package com.sjia.Leetcode;

public class MinimumPathSum {
    //  #64. Minimum Path Sum  https://leetcode.com/problems/minimum-path-sum/
    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
     */

    // Input: grid = [[1,3,1],[1,5,1],[4,2,1]]  Output: 7
    // Input: grid = [[1,2,3],[4,5,6]]  Output: 12

    
    // DP, row1, column1, rest
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Create a 2D dp array to store the minimum path sum for each cell
        int[][] dp = new int[m][n];

        // Initialize the first cell with its value
        dp[0][0] = grid[0][0];

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the dp array using dynamic programming
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // Return the minimum path sum to reach the bottom-right cell
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int minPathSum = minPathSum(grid);
        System.out.println("Minimum path sum: " + minPathSum); // Output: 7
    }


}
