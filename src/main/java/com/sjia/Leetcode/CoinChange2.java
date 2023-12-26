package com.sjia.Leetcode;

public class CoinChange2 {
    // #518. Coin Change II     https://leetcode.com/problems/coin-change-ii/

    // Compare to #377. Combination Sum IV

    /*
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

    You may assume that you have an infinite number of each kind of coin.

    The answer is guaranteed to fit into a signed 32-bit integer.

    Input: amount = 5, coins = [1,2,5]  Output: 4
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1

    Input: amount = 10, coins = [10]    Output: 1

    1 <= coins.length <= 300
    1 <= coins[i] <= 5000
    All the values of coins are unique.
    0 <= amount <= 5000
     */


    // dp, loop from coin to total
    // 3ms, 76.34%; 40.31mb, 63.35%
    public int change_dp_coin_total(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;


        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];

    }



    // coin from big to small;
    public int change_dp(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;


        for (int i = n-1; i >=0; i-- ) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }



    // dp2, coin to amount
    // 2 ms, 100%; 41 MB, 66.40%
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: 1 way to make 0 amount (by using no coins)

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }



    public static void main(String[] args) {
        CoinChange2 solution = new CoinChange2();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int ways = solution.change_dp(amount, coins);
        System.out.println("Number of ways to make change: " + ways); // Output: 4
    }


}
