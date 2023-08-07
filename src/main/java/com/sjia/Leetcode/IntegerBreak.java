package com.sjia.Leetcode;

public class IntegerBreak {
    // #343. Integer Break  https://leetcode.com/problems/integer-break/
    /*
    Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

    Return the maximum product you can get.

    Input: n = 2    Output: 1
    Explanation: 2 = 1 + 1, 1 × 1 = 1.

    Input: n = 10   Output: 36
    Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

     */

    public int integerBreak(int n) {
        if (n == 2) return 1;
        else if (n == 3) return 2;
        else if (n == 4) return 4;
        else if (n == 5) return 6;
        else if (n == 6) return 9;
        else if (n == 7) return 12;
        else if (n == 8) return 18;
        else if (n == 9) return 27;
        int[] dp = new int[n+1];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        dp[7] = 12;
        dp[8] = 18;
        dp[9] = 27;
        for ( int i=10; i<=n; i++) {
            if ( i%3 == 0) {
                dp[i] = 3 * dp[i-3];
            } else if ( i%3 == 1) {
                dp[i] = 4 * dp[i-4];
            } else {
                dp[i] = 2* dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak solution = new IntegerBreak();
        int n = 10;
        System.out.println(solution.integerBreak(n)); // Output: 36 (break into 3, 3, 4)

        n = 14;
        System.out.println(solution.integerBreak(n));

    }


}
