package com.sjia.Leetcode;

import java.util.Arrays;

public class BuyPensAndPencils {
    // #2240. Number of Ways to Buy Pens and Pencils    https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils

    /*
    You are given an integer total indicating the amount of money you have. You are also given two integers cost1 and cost2 indicating the price of a pen and pencil respectively. You can spend part or all of your money to buy multiple quantities (or none) of each kind of writing utensil.

    Return the number of distinct ways you can buy some number of pens and pencils.

    Input: total = 20, cost1 = 10, cost2 = 5    Output: 9
    Explanation: The price of a pen is 10 and the price of a pencil is 5.
    - If you buy 0 pens, you can buy 0, 1, 2, 3, or 4 pencils.
    - If you buy 1 pen, you can buy 0, 1, or 2 pencils.
    - If you buy 2 pens, you cannot buy any pencils.
    The total number of ways to buy pens and pencils is 5 + 3 + 1 = 9.
     */


    // convert to coin problem, from coin to total
    // 52 ms, 15.79%; 42.8 MB, 8.77%
    public long waysToBuyPensPencils_beibao(int total, int cost1, int cost2) {
        int[] dp = new int[total + 1];
        dp[0] = 1;


        int[] coins = {cost1, cost2};

        for (int coin : coins) {
            for (int i = 0; i <= total; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        long res = 0;
        for ( int n : dp) {
            res += n ;
        }
        return res;

    }



    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        final int maxPen = total / cost1;

        for (int i = 0; i <= maxPen; ++i)
            res += (total - i * cost1) / cost2 + 1;

        return res;
    }

    public static void main(String[] args) {
        BuyPensAndPencils solution = new BuyPensAndPencils();
        int[] coins = {10, 5};
        int amount = 20;
        long result = solution.waysToBuyPensPencils(amount, 10,5);
        System.out.println(result); // Output: 3 (11 = 5 + 5 + 1)
    }

}
