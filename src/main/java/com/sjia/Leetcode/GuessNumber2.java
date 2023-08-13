package com.sjia.Leetcode;

public class GuessNumber2 {
    // #375. Guess Number Higher or Lower II    https://leetcode.com/problems/guess-number-higher-or-lower-ii/
    /*
    Input: n = 10   Output: 16
    I pick a number between 1 and n.
    You guess a number.
    If you guess the right number, you win the game.
    If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
    Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
    Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number I pick.

     */



    // guess <= end , Index 11 out of bounds for length 11
    // guess < end,
    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;
                for (int guess = start; guess <= end; guess++) {
                    int cost = guess + Math.max(dp[start][guess - 1], dp[guess + 1][end]);
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        return dp[1][n];
    }


    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }





    public static void main(String[] args) {
        GuessNumber2 solution = new GuessNumber2();
        int n = 10;
        int minCost = solution.getMoneyAmount2(n);
        System.out.println("Minimum cost: " + minCost); // Output: 16
    }




}
