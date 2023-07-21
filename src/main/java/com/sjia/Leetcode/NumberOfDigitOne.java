package com.sjia.Leetcode;

public class NumberOfDigitOne {
    // #233. Number of Digit One    https://leetcode.com/problems/number-of-digit-one/
    /*
    Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

    Input: n = 13   Output: 6
    Input: n = 0    Output: 0
    0 <= n <= 10^9

    2304   : 1761

    个位： (230 +1 ) x 1
    十位： 23 x 10  =230
    百位：（2+1） x 100 =300
    千位： 1 x 1000


    90182 :
    (9018+1) x 1 = 9019
    (901 +1) x 10 = 9020
    90 x 100 + 82 +1 =9083
    9 x 1000 = 9000
    1 x 10000 =10000
    10000 + 9000 + 9083 + 9020 + 9019 = 46122

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

//        int n2 = 1314; // Output: 782

        int n2 = 99; // Output: 782
        System.out.println("Number of digit '1': " + numberOfDigitOne.countDigitOne(n2));

        int n3 = 2304; // Output: 1761
        System.out.println("Number of digit '1': " + numberOfDigitOne.countDigitOne(n3));

        int n4 = 90182; // Output: 46122
        System.out.println("Number of digit '1': " + numberOfDigitOne.countDigitOne(n4));
    }
}
