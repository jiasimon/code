package com.sjia.Leetcode;

public class Minesweeper {
    // #529. Minesweeper    https://leetcode.com/problems/minesweeper/description/

    /*
    Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
    Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]

    Input: board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
    Output: [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]

    board[i][j] is either 'M', 'E', 'B', or a digit from '1' to '8'.
    click.length == 2

    board[clickr][clickc] is either 'M' or 'E'.
     */


    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') {
            board[x][y] = 'X'; // Mine hit, game over
        } else {
            revealEmptyCells(board, x, y);
        }

        return board;
    }

    private void revealEmptyCells(char[][] board, int x, int y) {
        if (board[x][y] != 'E') return;

        int mines = countAdjacentMines(board, x, y);

        if (mines > 0) {
            board[x][y] = (char) ('0' + mines); // Convert integer to character
        } else {
            board[x][y] = 'B'; // Blank cell

            // Recursively reveal adjacent cells
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                    revealEmptyCells(board, nx, ny);
                }
            }
        }
    }

    private int countAdjacentMines(char[][] board, int x, int y) {
        int count = 0;

        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'M') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Minesweeper solution = new Minesweeper();

        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = {3, 0};

        char[][] updatedBoard = solution.updateBoard(board, click);

        System.out.println("Updated Board:");
        for (char[] row : updatedBoard) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


}
