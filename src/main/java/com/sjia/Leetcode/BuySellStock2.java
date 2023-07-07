package com.sjia.Leetcode;

import java.util.Arrays;

public class BuySellStock2 {

    // #122. Best Time to Buy and Sell Stock II https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    /*
    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

    Find and return the maximum profit you can achieve.
    1 <= prices.length <= 3 * 104
    0 <= prices[i] <= 104
     */

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
    //Memory Usage: 39.1 MB, less than 87.27% of Java online submissions for Best Time to Buy and Sell Stock II.

    public int maxProfit(int[] prices) {
        int result = 0;
        for ( int i = 1; i< prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                result += prices[i] - prices[i-1];
            }
        }
        return result;
    }



    // WithBuySell Day Info
    public int maxProfitWithBuyDay(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }

    public static void main(String[] args) {

        int[] testData  = {7,1,5,3,6,4};
        //int[] testData  = {7,6,4,3,1};
        BuySellStock2 solution = new BuySellStock2();
        int result = solution.maxProfitWithBuyDay(testData);

        System.out.printf("BuySellStock multi time, testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }

}
