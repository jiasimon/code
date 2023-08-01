package com.sjia.Leetcode;

import java.util.Arrays;

public class BuySellStock3 {

    // #123. Best Time to Buy and Sell Stock III https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

    /*
    Find the maximum profit you can achieve. You may complete at most two transactions.
    Input: prices = [3,3,5,0,0,3,1,4]   Output: 6
    Input: prices = [1,2,3,4,5] Output: 4
     */

    // Runtime: 2 ms, faster than 92.43% of Java online submissions for Best Time to Buy and Sell Stock III.
    //Memory Usage: 39.8 MB, less than 12.50% of Java online submissions for Best Time to Buy and Sell Stock III.

    // _i20, 2 for second tranc, 0 for "no stock"
    int maxProfit_with_cool(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }

        return dp_i20;
    }


    // buy1,buy2,sell1,sell2
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }


    // DP with min and max
    public int MaxProfitDpCompactFinal(int[] prices)  {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }

        return sell2;
    }

    public static void main(String[] args) {

        // int[] testData  = {7,1,5,3,6,4};
        //int[] testData  = {7,6,4,3,1};
         int[] testData  = {3,3,5,0,0,3,1,4};
        BuySellStock3 solution = new BuySellStock3();
        int result = solution.maxProfit(testData);

        System.out.printf("BuySellStock 2 times, testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }

}
