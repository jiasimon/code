package com.sjia.Leetcode;

public class WordSearch {
    // #79. Word Search  https://leetcode.com/problems/word-search/
    /*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
     */


    // Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    // Output: true


    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backtrack(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // Mark the cell as visited

        boolean found = backtrack(board, row + 1, col, word, index + 1)
                || backtrack(board, row - 1, col, word, index + 1)
                || backtrack(board, row, col + 1, word, index + 1)
                || backtrack(board, row, col - 1, word, index + 1);

        board[row][col] = temp; // Restore the original value

        return found;
    }


    public boolean exist_dfs(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // Mark as visited

        boolean found = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);

        board[i][j] = temp; // Restore the original character
        return found;
    }




    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        System.out.println("Word exists: " + exist(board, word)); // Output: true
    }


}
