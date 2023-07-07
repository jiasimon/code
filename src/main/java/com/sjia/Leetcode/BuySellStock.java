package com.sjia.Leetcode;

import java.util.Arrays;

public class BuySellStock {
    // #121. Best Time to Buy and Sell Stock  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    /*
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    Input: prices = [7,1,5,3,6,4]   Output: 5
    Input: prices = [7,6,4,3,1]     Output: 0

    1 <= prices.length <= 105
    0 <= prices[i] <= 10^4
     */

    // Runtime: 3 ms, faster than 21.97% of Java online submissions for Best Time to Buy and Sell Stock.
    //Memory Usage: 41.5 MB, less than 5.09% of Java online submissions for Best Time to Buy and Sell Stock.

    public int maxProfit(int[] prices) {
        if (prices == null | prices.length <2) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for (int i=0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }


    // Time Limit Exceeded, 202 / 211 testcases passed
    public int maxProfitTwoLoops(int[] prices) {
        if (prices.length <2) return 0;
        int res = 0;
        for (int i=0; i< prices.length; i++) {
            for (int j=i+1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i] );
            }
        }
        return res;
    }


    public static void main(String[] args) {

        //int[] testData  = {7,1,5,3,6,4};
        int[] testData  = {7,6,4,3,1};
        BuySellStock solution = new BuySellStock();
        int result = solution.maxProfit(testData);

        System.out.printf("BuySellStock testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }


}
