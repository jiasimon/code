package com.sjia.Leetcode;

public class FactorialTrailingZeroes {

    // #172. Factorial Trailing Zeroes https://leetcode.com/problems/factorial-trailing-zeroes/
    /*
    Given an integer n, return the number of trailing zeroes in n!.

    Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

    Input: n = 3    Output: 0
    Explanation: 3! = 6, no trailing zero.

    Input: n = 5    Output: 1
    Explanation: 5! = 120, one trailing zero.

     */

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

    // recursive
    // 0 ms, 100% ; 39.8 MB, 36.24%
    static int trailingZeroesRecursive(int n) {
        if ( n < 5) return 0;
        else {
            return n / 5 + trailingZeroesRecursive(n/5);
        }
    }


/*    public int trailingZeroes(int n) {
        int result=0;
        while (n > 0) {
            n /= 5;
            result += n;
        }
        return result;
    }*/

    public static void main(String[] args) {
        int testData = 25;
        int result = trailingZeroes(testData);
        System.out.printf("FactorialTrailingZeroes %s testData is:  %s", testData, result);

    }


}
