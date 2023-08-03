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








    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChangeRecursive(coins, amount);
        System.out.println(result); // Output: 3 (11 = 5 + 5 + 1)
    }


}
