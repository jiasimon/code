package com.sjia.Leetcode;

public class NthDigit {
    // #400. Nth Digit  https://leetcode.com/problems/nth-digit/description/

    /*
    Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

    Input: n = 3    Output: 3

    Input: n = 11   Output: 0
    Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10
     */


    // num.charAt((n - 1) % digits))
    public int findNthDigit(int n) {
        int digits = 1;
        long count = 9;
        int start = 1;

        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / digits;
        String num = Integer.toString(start);
        return Character.getNumericValue(num.charAt((n - 1) % digits));
    }


    public static void main(String[] args) {
        NthDigit solution = new NthDigit();
        int n = 15;
        int nthDigit = solution.findNthDigit(n);
        System.out.println("The " + n + "th digit is: " + nthDigit); // Output: 2
    }
}
