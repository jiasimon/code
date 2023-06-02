package com.sjia.Leetcode;

import java.util.Arrays;

public class Search2DMatrix {
    //  #74. Search a 2D Matrix  https://leetcode.com/problems/search-a-2d-matrix/
    /*
    You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.
     */

    // n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
    // an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }


    // from matrix[0][n-1] i++, j--
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i=0, j= n-1;
        while (i<m && j>=0 ) {
            if(matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target1 = 3;
        int target2 = 13;

        System.out.println("Matrix:");
//        System.out.println(Arrays.deepToString(matrix));
        printMatrix(matrix);

        System.out.println("Search result for target " + target1 + ": " + searchMatrix(matrix, target1)); // Output: true
        System.out.println("Search result for target " + target2 + ": " + searchMatrix(matrix, target2)); // Output: false
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
