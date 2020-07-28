package com.sjia.Leetcode;

public class FactorialTrailingZeroes {

    // #172 https://leetcode.com/problems/factorial-trailing-zeroes/

    // Runtime: 1 ms, faster than 47.58% of Java online submissions for Factorial Trailing Zeroes.
    //Memory Usage: 38.6 MB, less than 5.65% of Java online submissions for Factorial Trailing Zeroes.
    static int trailingZeroes(int n) {
        int result=0;
        while (n > 0) {
            result += n/5;
            n = n/5;
        }
        return result;
    }


    public static void main(String[] args) {
        int testData = 25;
        int result = trailingZeroes(testData);
        System.out.printf("FactorialTrailingZeroes %s testData is:  %s", testData, result);

    }


}
