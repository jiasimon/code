package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {
    // 52. N-Queens II  https://leetcode.com/problems/n-queens-ii/description/
    // The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    // Given an integer n, return the number of distinct solutions to the n-queens puzzle

    private static int totalSolutions;

    public static int totalNQueens(int n) {
        totalSolutions = 0;
        int[] queens = new int[n];
        placeQueens(queens, 0);
        return totalSolutions;
    }

    private static void placeQueens(int[] queens, int row) {
        if (row == queens.length) {
            totalSolutions++;
            return;
        }

        for (int col = 0; col < queens.length; col++) {
            if (isValidMove(queens, row, col)) {
                queens[row] = col;
                placeQueens(queens, row + 1);
            }
        }
    }

    private static boolean isValidMove(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int total = totalNQueens(n);
        // n = 4, Output: 2; n = 5, Output: 10
        System.out.println("With " + n + " Queens, Total Solutions: " + total);
    }


}
