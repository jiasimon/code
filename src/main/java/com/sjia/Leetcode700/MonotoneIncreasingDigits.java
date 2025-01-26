package com.sjia.Leetcode700;

public class MonotoneIncreasingDigits {
    // #738. Monotone Increasing Digits https://leetcode.com/problems/monotone-increasing-digits/description/
    /*
An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.

Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.

Input: n = 10   Output: 9

Input: n = 1234 Output: 1234

Input: n = 332  Output: 299

Convert the integer n to a character array for easier manipulation.
Traverse the digits from left to right to find the first decreasing pair.
When a decreasing pair is found, decrement the previous digit and set all following digits to 9.
Convert the modified character array back to an integer.
     */


    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int marker = digits.length;

        // Traverse digits from left to right to find a decreasing pattern
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                digits[i - 1]--;  // Decrease the previous digit
                marker = i;
            }
        }

        // Set all digits after the marker to '9'
        for (int i = marker; i < digits.length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits solution = new MonotoneIncreasingDigits();

        // Test cases
        System.out.println(solution.monotoneIncreasingDigits(332));  // Expected: 299
        System.out.println(solution.monotoneIncreasingDigits(1234)); // Expected: 1234
        System.out.println(solution.monotoneIncreasingDigits(120));  // Expected: 119
        System.out.println(solution.monotoneIncreasingDigits(10));   // Expected: 9
        System.out.println(solution.monotoneIncreasingDigits(9876)); // Expected: 8999
    }


}
