package com.sjia.Leetcode;

public class BuySellStock6 {
    // #714. Best Time to Buy and Sell Stock with Transaction Fee  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

    Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
    The transaction fee is only charged once for each stock purchase and sale.

    Input: prices = [1,3,2,8,4,9], fee = 2  Output: 8
    The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

    Input: prices = [1,3,7,5,10,3], fee = 3
    Output: 6

     */

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] free = new int[n];  // free : no stock
        int[] hold = new int[n];  // hold : have stock

        hold[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return free[n-1];

    }

    public static void main(String[] args) {
        BuySellStock6 solution = new BuySellStock6();

        // Test case
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = solution.maxProfit(prices, fee);
        System.out.println("Maximum Profit: " + result);  // Output: 8
    }




}
