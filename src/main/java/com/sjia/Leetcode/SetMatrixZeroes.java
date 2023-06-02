package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    //  73. Set Matrix Zeroes  https://leetcode.com/problems/set-matrix-zeroes/
    /*
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

    You must do it in place.
     */

    // Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    // Output: [[1,0,1],[0,0,0],[1,0,1]]

    // Use two sets to store 0 value position
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Set<Integer> rowsSet = new HashSet<>();
        Set<Integer> colsSet = new HashSet<>();

        for (int i=0; i < row; i++) {
            for ( int j=0; j< col; j++) {
                if( matrix[i][j] == 0 ) {
                    rowsSet.add(i);
                    colsSet.add(j);
                }
            }
        }

        for (int i=0; i < row; i++) {
            for ( int j=0; j< col; j++) {
                if( rowsSet.contains(i) || colsSet.contains(j) ) {
                    matrix[i][j] =0;
                }
            }
        }



    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Original Matrix:");
        printMatrix(matrix1);
        setZeroes(matrix1);
        System.out.println("Matrix after setting zeroes:");
        printMatrix(matrix1);

        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("Original Matrix:");
        printMatrix(matrix2);
        setZeroes(matrix2);
        System.out.println("Matrix after setting zeroes:");
        printMatrix(matrix2);
    }

    public static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



}
