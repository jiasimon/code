package com.sjia.Leetcode;

public class ZumaGame488 {
    // #488. Zuma Game      https://leetcode.com/problems/zuma-game/

    /*
    Input: board = "WRRBBW", hand = "RB"    Output: -1
    Explanation: It is impossible to clear all the balls. The best you can do is:
    - Insert 'R' so the board becomes WRRRBBW. WRRRBBW -> WBBW.
    - Insert 'B' so the board becomes WBBBW. WBBBW -> WW.

    Input: board = "WWRRBBWW", hand = "WRBRW"   Output: 2
    Explanation: To make the board empty:
    - Insert 'R' so the board becomes WWRRRBBWW. WWRRRBBWW -> WWBBWW.
    - Insert 'B' so the board becomes WWBBBWW. WWBBBWW -> WWWW -> empty.
    2 balls from your hand were needed to clear the board.

    1 <= board.length <= 16
    1 <= hand.length <= 5

     */


    // 49 / 57 testcases passed
    /*
    board = "RRWWRRBBRR",  hand ="WB"  Output:-1  Expected: 2
     */
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char ch : hand.toCharArray()) {
            handCount[ch - 'A']++;
        }

        return backtrack(board, handCount);
    }

    private int backtrack(String board, int[] handCount) {
        if (board.isEmpty()) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int i = 0;

        while (i < board.length()) {
            int j = i;

            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }

            int neededBalls = 3 - (j - i);
            if (handCount[board.charAt(i) - 'A'] >= neededBalls) {
                String newBoard = updateBoard(board.substring(0, i) + board.substring(j));
                handCount[board.charAt(i) - 'A'] -= neededBalls;
                int nextResult = backtrack(newBoard, handCount);
                if (nextResult != -1) {
                    result = Math.min(result, neededBalls + nextResult);
                }
                handCount[board.charAt(i) - 'A'] += neededBalls;
            }

            i = j;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private String updateBoard(String board) {
        int i = 0;
        while (i < board.length()) {
            int j = i;

            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }

            if (j - i >= 3) {
                return updateBoard(board.substring(0, i) + board.substring(j));
            }

            i = j;
        }

        return board;
    }

    public static void main(String[] args) {
        ZumaGame488 solution = new ZumaGame488();
        String board = "WRRBBW";
        String hand = "RB";

        int minSteps = solution.findMinStep(board, hand);
        System.out.println("Minimum Steps to Eliminate: " + minSteps);
    }
}
