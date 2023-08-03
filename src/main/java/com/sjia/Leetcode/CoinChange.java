package com.sjia.Leetcode;

import java.util.Arrays;

public class CoinChange {
    // #322. Coin Change    https://leetcode.com/problems/coin-change/description/
    /*
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

    Input: coins = [1,2,5], amount = 11     Output: 3
    Explanation: 11 = 5 + 5 + 1

    Input: coins = [2], amount = 3      Output: -1

     */


    // recursive TLE
    public int coinChangeRecursive(int[] coins, int amount) {
        if ( amount < 0) return -1;
        if ( amount == 0) return 0;
        int count = -1;
        for ( int i=0; i < coins.length; i++) {
            int tmp = coinChangeRecursive(coins, amount-coins[i]);
            if ( tmp != -1)  {
                if (count < 0) count = tmp+ 1;
                else count = Math.min(count, tmp + 1);
            }
        }
        return count;

    }



    // memo
    // 33ms, 29.47%; 43.63mb, 39.30%
    public int coinChange_memo(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int[] memo = new int[amount+1];
        Arrays.fill(memo,-2);
        return coinChange_memo(coins, amount, memo);
    }



    // dp , from total to coin
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount +1);

        dp[0] =0;
        for (int i=1; i<= amount; i++) {
            for(int coin: coins) {
                if( i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if(dp[amount] > amount) return -1;
        else return dp[amount];
    }








    private int coinChange_memo(int[] coins, int remain, int[] memo) {
        if ( remain < 0) return -1;
        if ( remain == 0) return 0;
        if (memo[remain] != -2) {
            return memo[remain];
        }

        int count = -1;
        for ( int i=0; i < coins.length; i++) {
            int tmp = coinChange_memo(coins, remain-coins[i], memo);
            if ( tmp != -1)  {
                if (count < 0) count = tmp+ 1;
                else count = Math.min(count, tmp + 1);
            }
        }
        memo[remain] = count;
        return count;
    }




    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChange_memo(coins, amount);
        System.out.println(result); // Output: 3 (11 = 5 + 5 + 1)
    }


}
