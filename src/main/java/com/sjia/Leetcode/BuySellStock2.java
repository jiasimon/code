package com.sjia.Leetcode;

import java.util.Arrays;

public class BuySellStock2 {

    // #122 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

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


    public static void main(String[] args) {

        int[] testData  = {7,1,5,3,6,4};
        //int[] testData  = {7,6,4,3,1};
        BuySellStock2 solution = new BuySellStock2();
        int result = solution.maxProfit(testData);

        System.out.printf("BuySellStock multi time, testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }

}
