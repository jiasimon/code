package com.sjia.Leetcode;

public class NumberOfDigitOne {
    // #233. Number of Digit One    https://leetcode.com/problems/number-of-digit-one/
    /*
    Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

    Input: n = 13   Output: 6
    Input: n = 0    Output: 0
    0 <= n <= 10^9

     */

    public int countDigitOne(int n) {
        int res = 0;

        for (long pow10 = 1; pow10 <= n; pow10 *= 10) {
            final long divisor = pow10 * 10;
            final int quotient = (int) (n / divisor);
            final int remainder = (int) (n % divisor);
            if (quotient > 0)
                res += quotient * pow10;
            if (remainder >= pow10)
                res += Math.min(remainder - pow10 + 1, pow10);
        }

        return res;
    }

    // Test the code
    public static void main(String[] args) {
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();

//        int n = 13; // Output: 6 (Explanation: The numbers with digit '1' in the range from 1 to 13 are 1, 10, 11, 12, 13, 1 appears 6 times.)
//        System.out.println("Number of digit '1': " + numberOfDigitOne.countDigitOne(n));

        int n2 = 1314; // Output: 782
        System.out.println("Number of digit '1': " + numberOfDigitOne.countDigitOne(n2));
    }
}
