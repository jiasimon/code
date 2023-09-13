package com.sjia.Leetcode;

public class KnightTour2596 {
    // #2596. Check Knight Tour Configuration   https://leetcode.com/problems/check-knight-tour-configuration/description/

    /*
    There is a knight on an n x n chessboard. In a valid configuration, the knight starts at the top-left cell of the board and visits every cell on the board exactly once.

    You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1] where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.

    Return true if grid represents a valid configuration of the knight's movements or false otherwise.

    n == grid.length == grid[i].length
    3 <= n <= 7
    0 <= grid[row][col] < n * n
    All integers in grid are unique.
     */


    public boolean isKnightTour(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        int n = grid.length;
        int[][] indices = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                indices[grid[i][j]][0] = i;
                indices[grid[i][j]][1] = j;
            }
        }

        for (int i = 1; i < n * n; i++) {
            int dx = Math.abs(indices[i][0] - indices[i - 1][0]);
            int dy = Math.abs(indices[i][1] - indices[i - 1][1]);
            if (dx * dy != 2) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidMove(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }


    
    public static void main(String[] args) {
        KnightTour2596 solution = new KnightTour2596();
        int n = 5;
        int[][] grid = {
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,8,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };

        boolean isValidTour = solution.isKnightTour(grid);
        System.out.println("Is a Valid Knight's Tour: " + isValidTour); // Output: true
    }
}
