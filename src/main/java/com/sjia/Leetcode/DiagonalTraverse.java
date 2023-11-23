package com.sjia.Leetcode;

import java.util.Arrays;

public class DiagonalTraverse {
    // #498. Diagonal Traverse      https://leetcode.com/problems/diagonal-traverse/

    /*
    Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
    Input: mat = [[1,2,3],[4,5,6],[7,8,9]]  Output: [1,2,4,7,5,3,6,8,9]
    Input: mat = [[1,2],[3,4]]      Output: [1,2,3,4]

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 10^4
    -10^5 <= mat[i][j] <= 10^5
     */

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];

        int row = 0, col = 0, d = 1;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];

            row -= d;
            col += d;

            if (row >= m) {
                row = m - 1;
                col += 2;
                d = -d;
            }

            if (col >= n) {
                col = n - 1;
                row += 2;
                d = -d;
            }

            if (row < 0) {
                row = 0;
                d = -d;
            }

            if (col < 0) {
                col = 0;
                d = -d;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse solution = new DiagonalTraverse();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] result = solution.findDiagonalOrder(matrix);
        System.out.println("Diagonal Traverse Result: " + Arrays.toString(result));
    }


}
