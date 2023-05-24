package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // #54. Spiral Matrix  https://leetcode.com/problems/spiral-matrix/

    // Given an m x n matrix, return all elements of the matrix in spiral order.
    // Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]  Output: [1,2,3,6,9,8,7,4,5]
    // Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]  Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    // m == matrix.length
    // n == matrix[i].length
    // 1 <= m, n <= 10
    // -100 <= matrix[i][j] <= 100


    // four pointers, rowBegin, rowEnd, colBegin, colEnd
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse the top row
            for (int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse the right column
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse the bottom row (if applicable)
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            // Traverse the left column (if applicable)
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> spiral = spiralOrder(matrix);
        System.out.println("Spiral Matrix: " + spiral); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }



}
