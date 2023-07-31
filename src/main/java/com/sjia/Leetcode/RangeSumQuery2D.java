package com.sjia.Leetcode;

public class RangeSumQuery2D {
    // #304. Range Sum Query 2D - Immutable https://leetcode.com/problems/range-sum-query-2d-immutable/description/
    /*
    Given a 2D matrix matrix, handle multiple queries of the following type:

    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    Implement the NumMatrix class:

    NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
    You must design an algorithm where sumRegion works on O(1) time complexity.

    Given matrix = [
      [3, 0, 1, 4, 2],
      [5, 6, 3, 2, 1],
      [1, 2, 0, 1, 5],
      [4, 1, 0, 1, 7],
      [1, 0, 3, 0, 5]
    ]

    sumRegion(2, 1, 4, 3) -> 8
    sumRegion(1, 1, 2, 2) -> 11
    sumRegion(1, 2, 2, 4) -> 12

     */

    private int[][] sums;

    public RangeSumQuery2D(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        sums = new int[rows][cols];

        // Compute the cumulative sum for the first row
        sums[0][0] = matrix[0][0];
        for (int j = 1; j < cols; j++) {
            sums[0][j] = sums[0][j - 1] + matrix[0][j];
        }

        // Compute the cumulative sum for the first column
        for (int i = 1; i < rows; i++) {
            sums[i][0] = sums[i - 1][0] + matrix[i][0];
        }

        // Compute the cumulative sum for the rest of the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sums == null || row1 < 0 || col1 < 0 || row2 >= sums.length || col2 >= sums[0].length || row1 > row2 || col1 > col2) {
            return 0;
        }

        int sumA = 0;
        int sumB = 0;
        int sumC = 0;

        // Get the sum of the submatrix A (top-left rectangle)
        if (row1 > 0 && col1 > 0) {
            sumA = sums[row1 - 1][col1 - 1];
        }

        // Get the sum of the submatrix B (top-right rectangle)
        if (row1 > 0) {
            sumB = sums[row1 - 1][col2];
        }

        // Get the sum of the submatrix C (bottom-left rectangle)
        if (col1 > 0) {
            sumC = sums[row2][col1 - 1];
        }

        // Get the sum of the submatrix D (bottom-right rectangle)
        int sumD = sums[row2][col2];

        // Calculate the sum of the submatrix with coordinates [(row1, col1), (row2, col2)]
        return sumD - sumB - sumC + sumA;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        RangeSumQuery2D numMatrix = new RangeSumQuery2D(matrix);

        // Test cases
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // Output: 8 (2 + 0 + 1 + 0 + 3 + 0 + 1 + 5)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // Output: 11 (6 + 3 + 2 + 0)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // Output: 12 (3 + 2 + 1 + 5 + 0 + 1)
    }


}
