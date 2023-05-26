package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {
    // 52. N-Queens II  https://leetcode.com/problems/n-queens-ii/description/
    // The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    // Given an integer n, return the number of distinct solutions to the n-queens puzzle

    public static int solveNQueensCount(int n) {
        int res = 0;
        res = solveNQueens(n).size();
        return res;
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(result, board, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            result.add(constructSolution(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValidMove(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1);  // follow up the idea
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check if there is a queen in the diagonal (\)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check if there is a queen in the diagonal (/)
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }




    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

        int totalSolution = solveNQueensCount(n);
        System.out.println("totalSolution for " + n + " NQueens is : " + totalSolution);


    }


}