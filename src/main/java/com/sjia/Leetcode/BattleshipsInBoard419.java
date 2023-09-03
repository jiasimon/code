package com.sjia.Leetcode;

public class BattleshipsInBoard419 {
    // #419. Battleships in a Board     https://leetcode.com/problems/battleships-in-a-board/description/

    /*
    Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

    Battleships can only be placed horizontally or vertically on board.

    ...X
    XXXX
    ...X

    This is an invalid board that you will not receive - as battleships will always have a cell separating between them.

    compare to #200 islands
     */


    // Two scans
    // 1 ms, 74.70%; 44.6 MB, 7.91%
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int res =0 ;

        for ( int i = 0; i < m ; i++) {
            for ( int j = 0 ; j < n; j++) {
                if (board[i][j] != 'X') {
                    continue;
                }
                board[i][j] = '-';
                for ( int k = i+1; k < m && board[k][j] == 'X'; k++) board[k][j] = '-';
                for ( int p = j + 1; p < n && board[i][p] == 'X'; p++ ) board[i][p] = '-';
                res++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '-') board[i][j] = 'X';
            }
        }
        return res;
    }


    public static void main(String[] args) {
        BattleshipsInBoard419 solution = new BattleshipsInBoard419();
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };
        int numBattleships = solution.countBattleships(board);
        System.out.println("Number of battleships: " + numBattleships);
    }


}
