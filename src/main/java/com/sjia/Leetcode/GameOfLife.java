package com.sjia.Leetcode;

public class GameOfLife {
    // #289. Game of Life   https://leetcode.com/problems/game-of-life/
    /*
    Any live cell with fewer than two live neighbors dies as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population.
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

    Input:
    [
      [0,1,0],
      [0,0,1],
      [1,1,1],
      [0,0,0]
    ]
    Output:
    [
      [0,0,0],
      [1,0,1],
      [0,1,1],
      [0,1,0]
    ]
     */


    // conway, revisit
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] nextGeneration = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextGeneration[i][j] = 0;
                    } else {
                        nextGeneration[i][j] = 1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextGeneration[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.arraycopy(nextGeneration[i], 0, board[i], 0, n);
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col, int m, int n) {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int liveNeighbors = 0;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                liveNeighbors += board[newRow][newCol] & 1;
            }
        }

        return liveNeighbors;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        GameOfLife solution = new GameOfLife();
        solution.gameOfLife(board);

        System.out.println("Next generation of the board:");
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }



}
