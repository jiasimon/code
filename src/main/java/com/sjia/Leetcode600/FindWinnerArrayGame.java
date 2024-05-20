package com.sjia.Leetcode600;

public class FindWinnerArrayGame {
    // #1535. Find the Winner of an Array Game  https://leetcode.com/problems/find-the-winner-of-an-array-game/description/
    /*
    Given an integer array arr of distinct integers and an integer k.

    A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0, and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.

    Return the integer which will win the game.

    It is guaranteed that there will be a winner of the game.

    Input: arr = [2,1,3,5,4,6,7], k = 2     Output: 5
    Input: arr = [3,2,1], k = 10            Output: 3

     */

    // one pass, If you don't find the winner after one pass,
    // the winner will be max(A),
    public int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int winCount = 0;

        for (int i=1;  i < arr.length; i++) {
            if(arr[i] > winner) {
                winner = arr[i];
                winCount = 1;
            } else {
                winCount++;
            }
            if (winCount == k) {
                return winner;
            }
        }

        return winner;
    }

    public static void main(String[] args) {
        // Test case
        int[] arr = {2, 1, 3, 5, 4, 6, 7};
        int k = 2;

        FindWinnerArrayGame solution = new FindWinnerArrayGame();
        int winner = solution.getWinner(arr, k);

        System.out.println("Winner: " + winner);
    }


}
