package com.sjia.Leetcode;

public class MaximalSquare {
    // #221. Maximal Square     https://leetcode.com/problems/maximal-square/
    /*
    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    Output: 4
     */


    // dp,
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        // Initialize the first row and first column of the DP array
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxSide = Math.max(maxSide, dp[i][0]);
        }

        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j] - '0';
            maxSide = Math.max(maxSide, dp[0][j]);
        }

        // Build the DP array for the remaining cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    // If the cell is '1', update the DP value based on adjacent cells
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // The maxSide value represents the length of the largest square
        // Return the area of the square (maxSide^2)
        return maxSide * maxSide;
    }


    // matrix[i][j] == '1' ? 1 : 0
    public int maximalSquare2(char[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0 || matrix[i][j] == '0')
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                maxLength = Math.max(maxLength, dp[i][j]);
            }

        return maxLength * maxLength;

    }



    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int result = maximalSquare.maximalSquare(matrix);
        System.out.println("The area of the largest square: " + result); // Output: 4
    }


}
