package com.sjia.Leetcode;

public class BuySellStock5 {
    // #309. Best Time to Buy and Sell Stock with Cooldown  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    /*
    Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
    Input: prices = [1,2,3,0,2] Output: 3
    Input: prices = [1] Output: 0

    1 <= prices.length <= 5000
    0 <= prices[i] <= 1000
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];

        buy[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return Math.max(sell[n - 1], cooldown[n - 1]);
    }


    public static void main(String[] args) {
        BuySellStock5 solution = new BuySellStock5();

        // Test case 1
        int[] prices1 = {1, 2, 3, 0, 2};
        int result1 = solution.maxProfit(prices1);
        System.out.println("Maximum Profit for Test Case 1: " + result1);  // Output: 3

        // Test case 2
        int[] prices2 = {2, 1, 4};
        int result2 = solution.maxProfit(prices2);
        System.out.println("Maximum Profit for Test Case 2: " + result2);  // Output: 3
    }


}

