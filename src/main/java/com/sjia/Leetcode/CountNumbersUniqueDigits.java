package com.sjia.Leetcode;

public class CountNumbersUniqueDigits {
    // #357. Count Numbers with Unique Digits   https://leetcode.com/problems/count-numbers-with-unique-digits/description/
    /*
    Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10^n.

    0 <= n <= 8
    Input: n = 0    Output: 1
    Input: n = 1    Output: 10
    Input: n = 2    Output: 91  ( 100 -9)
     */

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 10; // For n = 1
        int uniqueDigits = 9;
        int availableDigits = 9;

        for (int i = 2; i <= n && availableDigits > 0; i++) {
            uniqueDigits *= availableDigits;
            result += uniqueDigits;
            availableDigits--;
        }

        return result;
    }

    public static void main(String[] args) {
        CountNumbersUniqueDigits solution = new CountNumbersUniqueDigits();
        int n = 3;
        int count = solution.countNumbersWithUniqueDigits(n);
        System.out.println("Count of numbers with unique digits: " + count); // Output: 739 = 10 + 9x9 + 9x9x8
    }


}
