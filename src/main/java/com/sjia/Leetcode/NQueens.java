package com.sjia.Leetcode;

import java.util.*;

public class NQueens {
    // 51. N-Queens  https://leetcode.com/problems/n-queens/
    // Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

    // Input: n = 4
    // Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    // Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

    // 1 <= n <= 9

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

    private static List<String> constructEvenRowSolution(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        int start = 1, gap = 2;
        for (int i=0; i < n; i ++) {
            if ( start >= n) {
                start = start - n - 1;
            }
            board[i][start] = 'Q';
            start = start + gap;
        }
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }


    private static List<String> constructOddRowSolution(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        int start = 0 , gap = 2;
        for (int i=0; i < n; i ++) {
            if ( start >= n) {
                start = start - n ;
            }
            board[i][start] = 'Q';
            start = start + gap;
        }
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }


    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(7);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

        System.out.println("construct one of EvenRowSolution: ");

        List<String> mySolution = constructEvenRowSolution(6);
        for ( String row : mySolution) {
            System.out.println(row);
        }
        System.out.println();

        System.out.println("construct one of EvenRowSolution: ");

        List<String> mySolution2 = constructOddRowSolution(7);
        for ( String row : mySolution2) {
            System.out.println(row);
        }
        System.out.println();


    }
}
