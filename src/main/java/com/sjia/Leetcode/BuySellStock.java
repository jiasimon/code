package com.sjia.Leetcode;

import java.util.Arrays;

public class BuySellStock {
    // #121 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

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

    public static void main(String[] args) {

        //int[] testData  = {7,1,5,3,6,4};
        int[] testData  = {7,6,4,3,1};
        BuySellStock solution = new BuySellStock();
        int result = solution.maxProfit(testData);

        System.out.printf("BuySellStock testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }


}
