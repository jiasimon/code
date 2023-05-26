package com.sjia.Leetcode;

import java.util.Arrays;

public class SpiralMatrix2 {
    // #59. Spiral Matrix II  https://leetcode.com/problems/spiral-matrix-ii/

    // Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
    // Input: n = 3  Output: [[1,2,3],[8,9,4],[7,6,5]]
    // Input: n = 1  Output: [[1]]

    // 1 <= n <= 20

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        if (n == 1) {
            res[0][0] = 1;
            return res;
        }

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        int num = 1;
        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num;
                num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = num;
                num++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                res[bottom][i] = num;
                num++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                res[i][left] = num;
                num++;
            }
            left++;

        }
        return res;
    }


    public static int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;

        }
        return res;
    }


        public static void main (String[]args){
//            int n = 3;  // [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
            int n = 4; // [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
            int[][] matrix = generateMatrix2(n);
            System.out.println("n= " + n + " , generated Spiral Matrix is :" + Arrays.deepToString(matrix));
        }


    }
