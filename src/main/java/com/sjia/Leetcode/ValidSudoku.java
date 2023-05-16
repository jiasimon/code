package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    // #36 Valid Sudoku https://leetcode.com/problems/valid-sudoku/

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Sudoku.
    //Memory Usage: 39.2 MB, less than 88.99% of Java online submissions for Valid Sudoku.

    // add test case


    // for box: i / 3 + "-" + j / 3 
    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char tmp = board[i][j];
                if (tmp != '.') {
                    if (!seen.add(tmp + " in row " + i) ||
                            !seen.add(tmp + " in column " + j) ||
                            !seen.add(tmp + " in box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }

                }
            }
        }

        return true;

    }

    public static boolean isValidSudoku2(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sbox = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int index_box = (i / 3) * 3 + j / 3;
                    if (rows[i][num] == 1) {
                        return false;
                    } else {
                        rows[i][num] = 1;
                    }
                    if (col[j][num] == 1) {
                        return false;
                    } else {
                        col[j][num] = 1;
                    }
                    if (sbox[index_box][num] == 1) {
                        return false;
                    } else {
                        sbox[index_box][num] = 1;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'1', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean isValid = isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + isValid);
    }


}
