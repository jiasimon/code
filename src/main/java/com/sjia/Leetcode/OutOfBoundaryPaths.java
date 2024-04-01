package com.sjia.Leetcode;

public class OutOfBoundaryPaths {
    // #576. Out of Boundary Paths  https://leetcode.com/problems/out-of-boundary-paths/description/

    /*
    There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

    Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 10^9 + 7.

    Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0     Output: 6
     */

    int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int move = 1; move <= maxMove; move++) {
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    for (int[] dir : directions) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];
                        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                            dp[row][col][move]++; // Increment count if move is out of boundary
                        } else {
                            dp[row][col][move] = (dp[row][col][move] + dp[newRow][newCol][move - 1]) % MOD;
                        }
                    }
                }
            }
        }

        return dp[startRow][startColumn][maxMove];
    }


    public static void main(String[] args) {
        OutOfBoundaryPaths solution = new OutOfBoundaryPaths();

        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;

        System.out.println("Test Case 1: " + solution.findPaths(m, n, maxMove, startRow, startColumn)); // Output: 6
    }


}
