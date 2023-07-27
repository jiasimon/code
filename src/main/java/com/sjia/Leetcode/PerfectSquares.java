package com.sjia.Leetcode;

import java.util.Arrays;

public class PerfectSquares {
    // #279. Perfect Squares    https://leetcode.com/problems/perfect-squares/
    /*
    Given an integer n, return the least number of perfect square numbers that sum to n.

    A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
    For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

    Input: n = 12   Output: 3
    Explanation: 12 = 4 + 4 + 4.

    Input: n = 13   Output: 2
    Explanation: 13 = 4 + 9.

     */


    // recursive, TLE
    public int numSquares(int n) {
        if ( n < 4) return n;

        int res = n;

/*        for ( int i= (int)Math.sqrt(n) ; i>=1 ; i--) {
            int square = i * i;
            res = Math.min(res, 1 + numSquares( n - i*i) );
        }
        */

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            res = Math.min(res, 1 + numSquares(n - square));
        }


        return res;
    }



    // top down memo
    // 61ms, 44.12%; 42.44mb, 82.02%
    public int numSquaresMemo(int n) {
        int[] memo = new int [n+1];
        return numSquaresHelper(n, memo);
    }

    public int numSquaresHelper(int n, int[] memo ) {
        if ( n < 4) return n;

        if(memo[n] != 0) return memo[n];

        int res = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            res = Math.min(res, 1 + numSquaresHelper(n - square, memo));
        }

        memo[n] = res;
        return res;
    }



    // dp bottom up
    // 33ms,  85.22%; 42.82mb, 48.30%
    public int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 9);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }




    public static void main(String[] args) {
        int n = 101;
        PerfectSquares solution = new PerfectSquares();
        int result = solution.numSquaresDP(n);
        System.out.println("The least number of perfect squares required to sum up to " + n + " is: " + result);
        // Output: The least number of perfect squares required to sum up to 12 is: 3

        n= 10;
        result = solution.numSquaresDP(n);
        System.out.println("The least number of perfect squares required to sum up to " + n + " is: " + result);
        //

    }




}
