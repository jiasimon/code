package com.sjia.Leetcode;

import java.util.Arrays;

public class BuySellStock3 {

    // #123 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

    // Runtime: 2 ms, faster than 92.43% of Java online submissions for Best Time to Buy and Sell Stock III.
    //Memory Usage: 39.8 MB, less than 12.50% of Java online submissions for Best Time to Buy and Sell Stock III.

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

    public static void main(String[] args) {

        // int[] testData  = {7,1,5,3,6,4};
        //int[] testData  = {7,6,4,3,1};
         int[] testData  = {3,3,5,0,0,3,1,4};
        BuySellStock3 solution = new BuySellStock3();
        int result = solution.maxProfit_with_cool(testData);

        System.out.printf("BuySellStock 2 times, testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }

}
