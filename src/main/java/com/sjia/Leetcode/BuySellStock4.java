package com.sjia.Leetcode;

import java.util.Arrays;

public class BuySellStock4 {
    // #188. Best Time to Buy and Sell Stock IV  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
    /*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
    Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Input: k = 2, prices = [2,4,1]  Output: 2
    Input: k = 2, prices = [3,2,6,5,0,3]    Output: 7

    1 <= k <= 100
    1 <= prices.length <= 1000
    0 <= prices[i] <= 1000
     */

    // based on #123, sell[0] for edge case
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }


    public static void main(String[] args) {

        // int[] testData  = {7,1,5,3,6,4};
        //int[] testData  = {7,6,4,3,1};
        int[] testData  = {3,3,5,0,0,3,1,4};
        BuySellStock4 solution = new BuySellStock4();
        int result = solution.maxProfit(3, testData);

        System.out.printf("BuySellStock 3 times, testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }

}
