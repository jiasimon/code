package com.sjia.Leetcode;

public class ToeplitzMatrix {
    // #766 https://leetcode.com/problems/toeplitz-matrix/
    // Input:
    // matrix = [
    //  [1,2,3,4],
    //  [5,1,2,3],
    //  [9,5,1,2]
    // ]


    // Runtime: 1 ms, faster than 94.33% of Java online submissions for Toeplitz Matrix.
    //Memory Usage: 39.5 MB, less than 72.19% of Java online submissions for Toeplitz Matrix
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=1; i < m; i++) {
            for (int j=1; j < n; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) return false;
            }
        }
        return true;
    }


}
