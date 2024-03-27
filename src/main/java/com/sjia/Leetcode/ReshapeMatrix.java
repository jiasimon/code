package com.sjia.Leetcode;

public class ReshapeMatrix {
    // #566. Reshape the Matrix     https://leetcode.com/problems/reshape-the-matrix/description/
    /*
    You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

    Input: mat = [[1,2],[3,4]], r = 1, c = 4    Output: [[1,2,3,4]]

    1 <= m, n <= 100
    -1000 <= mat[i][j] <= 1000
    1 <= r, c <= 300
     */

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] reshaped = new int[r][c];
        int row = 0, col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reshaped[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return reshaped;
    }


    public static void main(String[] args) {
        ReshapeMatrix solution = new ReshapeMatrix();

        int[][] testMatrix = {
                {1, 2},
                {3, 4}
        };
        int r = 1, c = 4;

        int[][] reshapedMatrix = solution.matrixReshape(testMatrix, r, c);
        System.out.println("Test Case 1:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(reshapedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        // Output:
        // 1 2 3 4
    }


}
