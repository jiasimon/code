package com.sjia.Leetcode;

public class SurroundedRegions {
    // #130. Surrounded Regions https://leetcode.com/problems/surrounded-regions/
    /*
    Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
    Explanation: Notice that an 'O' should not be flipped if:
    - It is on the border, or
    - It is adjacent to an 'O' that should not be flipped.

    1 <= m, n <= 200
    board[i][j] is 'X' or 'O'.

        O's won't be flipped          O's will be flipped
        [X O X X X]                   [X X X X X]
        [X O O O X]                   [X O O O X]
        [X O X X X]                   [X O X X X]
        [X X X X X]                   [X X X X X]

      So we can conclude if a chain of adjacent O's is connected some O on boundary then they cannot be flipped



     */

    //
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark 'O' connected to border as '*' for first and last column
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        // Step 2: Mark 'O' connected to border as '*' for first and last row
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        // Step 3: Convert remaining 'O' to 'X' and '*' to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int r = board.length;
        int c = board[0].length;

        if (row < 0 || row >= r || col < 0 || col >= c || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '*';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }


    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();

        // Test case
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solution.solve(board);

        // Print the modified board
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }





}
