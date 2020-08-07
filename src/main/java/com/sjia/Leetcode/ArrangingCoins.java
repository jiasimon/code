package com.sjia.Leetcode;

public class ArrangingCoins {
    // #441 https://leetcode.com/problems/arranging-coins/
    // 1,3,5
    // n is a non-negative integer


    // math, Runtime: 1 ms, faster than 100.00% of Java online submissions for Arranging Coins.
    //Memory Usage: 36.9 MB, less than 25.00% of Java online submissions for Arranging Coins.
    public int arrangeCoins(int n) {
        if (n==0) return 0;
        double result = (Math.sqrt(1 + 8.0 * n)-1) / 2;
        return (int)result;
    }

    public static void main(String[] args) {
        int testData  = 1804289383;
        ArrangingCoins solution = new ArrangingCoins();
        int result = solution.arrangeCoins(testData);

        System.out.printf("testData %s arrangeCoins is %s \n", testData,result);
    }

}
