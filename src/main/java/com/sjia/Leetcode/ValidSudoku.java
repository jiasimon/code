package com.sjia.Leetcode;

public class ValidSudoku {

    // #36 https://leetcode.com/problems/valid-sudoku/

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Sudoku.
    //Memory Usage: 39.2 MB, less than 88.99% of Java online submissions for Valid Sudoku.

    class Solution {

        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] col = new int[9][9];
            int[][] sbox = new int[9][9];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j]!='.'){
                        int num = board[i][j] - '1';
                        int index_box = (i/3)*3+j/3;
                        if (rows[i][num]==1) { return false;}
                        else { rows[i][num]=1; }
                        if (col[j][num]==1) { return false;}
                        else { col[j][num]=1; }
                        if (sbox[index_box][num]==1)  { return false;}
                        else { sbox[index_box][num]=1; }
                    }
                }
            }
            return true;
        }
    }


}
