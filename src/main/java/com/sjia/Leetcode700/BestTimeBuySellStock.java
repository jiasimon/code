package com.sjia.Leetcode700;

public class BestTimeBuySellStock {
    // #714. Best Time to Buy and Sell Stock with Transaction Fee   https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
    /*

     */



    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;

        // Initialize two states:
        // cash: maximum profit if we are not holding a stock
        // hold: maximum profit if we are currently holding a stock
        int cash = 0;
        int hold = -prices[0];

        // Iterate through each day's price
        for (int i = 1; i < n; i++) {
            // Update cash and hold states
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        // The maximum profit will be in cash, where we are not holding any stock
        return cash;
    }

    public static void main(String[] args) {
        BestTimeBuySellStock solution = new BestTimeBuySellStock();

        // Test Case 1
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;
        System.out.println(solution.maxProfit(prices1, fee1)); // Output: 8

        // Test Case 2
        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;
        System.out.println(solution.maxProfit(prices2, fee2)); // Output: 6

        // Test Case 3
        int[] prices3 = {1, 2, 3, 4, 5};
        int fee3 = 1;
        System.out.println(solution.maxProfit(prices3, fee3)); // Output: 3
    }


}
