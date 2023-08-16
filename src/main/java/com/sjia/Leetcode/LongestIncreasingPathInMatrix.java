package com.sjia.Leetcode;

public class LongestIncreasingPathInMatrix {
    // #329. Longest Increasing Path in a Matrix
    // https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

    /*
    Given an m x n integers matrix, return the length of the longest increasing path in matrix.

    From each cell, you can either move in four directions: left, right, up, or down.
    You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

    nums = [
      [9,9,4],
      [6,6,8],
      [2,1,1]
    ]

    Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]   Output: 4
    The longest increasing path is [1, 2, 6, 9].

    nums = [
      [3,4,5],
      [3,2,6],
      [2,2,1]
    ]

    Compare to #200 Number of Islands

     */


    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, -1, memo);  // or prev = Integer.MIN_VALUE
                res = Math.max(res, len);
            }
        }
        return res;

    }

    // dfs, prev, memo
    private int dfs(int[][] matrix, int i, int j, int prev, int[][] memo) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= prev) {
            return 0;
        }
        if (memo[i][j] != 0) return memo[i][j];

        // recursive visit four directions

        int tmp = matrix[i][j];
        int a1 = dfs(matrix, i - 1, j, tmp, memo);

        int a2 = dfs(matrix, i + 1, j, tmp, memo);

        int a3 = dfs(matrix, i, j - 1, tmp, memo);

        int a4 = dfs(matrix, i, j + 1, tmp, memo);

        return memo[i][j] = 1 + Math.max(Math.max(a1, a2), Math.max(a3, a4));

    }



    // directions array
    // 9ms, 77.69%; 44.34mb, 22.40%
    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int longestIncreasingPath_directionArray(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxLength = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, memo));
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int maxLength = 1;

        // loop each direction
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }

        memo[i][j] = maxLength;
        return maxLength;
    }




    public static void main(String[] args) {
        LongestIncreasingPathInMatrix solution = new LongestIncreasingPathInMatrix();
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        int result = solution.longestIncreasingPath(matrix);
        System.out.println(result); // Output: 4 (The longest increasing path is [1, 2, 6, 9])
    }


}
