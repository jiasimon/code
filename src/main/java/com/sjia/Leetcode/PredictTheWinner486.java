package com.sjia.Leetcode;

public class PredictTheWinner486 {
    // #486. Predict the Winner     https://leetcode.com/problems/predict-the-winner/description/

    /*
    Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.

    Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.

    Input: nums = [1,5,2]   Output: false
    Input: nums = [1,5,233,7]   Output: true

    1 <= nums.length <= 20
    0 <= nums[i] <= 10^7
     */

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        // Initialize the diagonal elements when only one element is chosen
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        PredictTheWinner486 solution = new PredictTheWinner486();
        int[] nums = {1, 5, 2};

        boolean canPredictWinner = solution.PredictTheWinner(nums);
        System.out.println("Can Player 1 predict the winner?: " + canPredictWinner);
    }
}
