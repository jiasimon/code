package com.sjia.Leetcode;

public class IntWithoutConsecutiveOnes {
    // #600. Non-negative Integers without Consecutive Ones https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/description/

    /*
    Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.
    Input: n = 5    Output: 5

    1 <= n <= 10^9
     */

    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int result = a[n - 1] + b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }

        return result;
    }

    public static void main(String[] args) {
        IntWithoutConsecutiveOnes solution = new IntWithoutConsecutiveOnes();

        int n = 5;
        System.out.println("Test Case 1: " + solution.findIntegers(n)); // Output: 5
    }


}
