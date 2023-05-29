package com.sjia.Leetcode;

import java.util.Arrays;

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


    // DP, O(1) ,modify input
    public static int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        // Fill the first row
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the dp array using dynamic programming
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        // Return the minimum path sum to reach the bottom-right cell
        return grid[m - 1][n - 1];
    }


    // recursive,
    // TLE,   25 / 61  passed
    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length ;
        return minPathSumRecursive(grid, m - 1, n - 1); // m-1 instead of m
    }

    private static int minPathSumRecursive(int[][] grid, int i, int j) {
        if ( i==0 && j==0) {
            return grid[i][j];
        }

//        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if ( i==0) {
            return grid[i][j] + minPathSumRecursive(grid, i, j - 1);
        }

        if (j==0) {
            return grid[i][j] + minPathSumRecursive(grid, i-1, j );
        }

        return grid[i][j] + Math.min(minPathSumRecursive(grid, i, j - 1), minPathSumRecursive(grid, i-1, j ));


    }


    // memorization, memoization
    public static int minPathSum4(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length ;
        int[][] dp = new int[m][n];
        for ( int[] row : dp) {
            Arrays.fill(row,-1);
        }

        return minPathSumDP(grid, m - 1, n - 1, dp); // m-1 instead of m
    }

    private static int minPathSumDP(int[][] grid, int i, int j, int[][] dp) {
        if ( i==0 && j==0) {
            return grid[i][j];
        }

        if ( i==0) {
            return grid[i][j] + minPathSumDP(grid, i, j - 1, dp);
        }

        if (j==0) {
            return grid[i][j] + minPathSumDP(grid, i-1, j,dp );
        }
        if (dp[i][j] != -1)  {
            return dp[i][j];
        }

        dp[i][j] = grid[i][j] + Math.min(minPathSumDP(grid, i, j - 1, dp), minPathSumDP(grid, i-1, j, dp ));
        return dp[i][j];

    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int minPathSum = minPathSum4(grid);
        System.out.println("Minimum path sum: " + minPathSum); // Output: 7
    }


}
