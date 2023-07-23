package com.sjia.Leetcode;

public class Search2DMatrix2 {
    // #240. Search a 2D Matrix II  https://leetcode.com/problems/search-a-2d-matrix-ii/
    /*
    Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
    Output: false
     */


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int r = matrix.length;
        int c = matrix[0].length;

        int row = 0;
        int col = c-1;

         while (row < r && col >=0 ) {
             if (matrix[row][col] == target) {
                 return true;
             } else if (matrix[row][col] < target) {
                 row++;
             } else {
                 col--;
             }
         }
         return false;
    }


    public static void main(String[] args) {
        Search2DMatrix2 Search2DMatrix2 = new Search2DMatrix2();

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target1 = 5;
        int target2 = 20;

        System.out.println("Matrix contains target1: " + Search2DMatrix2.searchMatrix(matrix, target1)); // Output: true
        System.out.println("Matrix contains target2: " + Search2DMatrix2.searchMatrix(matrix, target2)); // Output: false
    }


}
