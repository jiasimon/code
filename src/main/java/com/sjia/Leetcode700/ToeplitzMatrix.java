package com.sjia.Leetcode700;

public class ToeplitzMatrix {
    // #766. Toeplitz Matrix https://leetcode.com/problems/toeplitz-matrix/
    /*
    Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]   Output: true

    Input: matrix = [[1,2],[2,2]]   Output: false
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 20
    0 <= matrix[i][j] <= 99

     */

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int col = 0; col < cols; col++) {
            if (!checkDiagonal(matrix, 0, col)) return false;
        }

        for (int row = 1; row < rows; row++) {
            if (!checkDiagonal(matrix, row, 0)) return false;
        }
        return true;

    }

    private boolean checkDiagonal(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        int rows = matrix.length;
        int cols = matrix[0].length;

        while (row < rows && col < cols) {
            if (matrix[row][col] != value) return false;
            row++;
            col++;
        }

        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix solution = new ToeplitzMatrix();
        int[][] matrix1 = {
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}
        };
        System.out.println(solution.isToeplitzMatrix(matrix1)); // Output: true

        int[][] matrix2 = {
            {1, 2},
            {2, 2}
        };
        System.out.println(solution.isToeplitzMatrix(matrix2)); // Output: false
    }

}
