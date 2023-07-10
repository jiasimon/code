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
//            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }

        return Math.max(sell[n - 1], cooldown[n - 1]);
    }



    // state machine
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/75928/share-my-dp-solution-by-state-machine-thinking/
    public int maxProfitStateGraph(int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        int[] s0 = new int[n];  // cooldown/rest, s2 ->s0, hold ->s0
        int[] s1 = new int[n];  // buy  ,  hold ->s1, s0 -> s1
        int[] s2 = new int[n];  // sell ,  s1 ->s2

        s0[0] = 0; // covered by array init, explicitly
        s1[0] = -prices[0];
        s2[0] = 0;

        for (int i = 1; i < n; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }

        return Math.max(s2[n - 1], s0[n - 1]);
    }

    public static void main(String[] args) {
        BuySellStock5 solution = new BuySellStock5();

        // Test case 1
        int[] prices1 = {1, 2, 3, 0, 2};
        int result1 = solution.maxProfitStateGraph(prices1);
        System.out.println("Maximum Profit for Test Case 1: " + result1);  // Output: 3

        // Test case 2
        int[] prices2 = {2, 1, 4};
        int result2 = solution.maxProfitStateGraph(prices2);
        System.out.println("Maximum Profit for Test Case 2: " + result2);  // Output: 3


        // Test case 3
        int[] prices3 = {3,3,5,0,0,3,1,4};
        int result3 = solution.maxProfitStateGraph(prices3);
        System.out.println("Maximum Profit for Test Case 2: " + result3);  // Output: 6

    }


}

