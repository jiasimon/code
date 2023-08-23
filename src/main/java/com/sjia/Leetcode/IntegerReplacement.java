package com.sjia.Leetcode;

public class IntegerReplacement {
    // #397. Integer Replacement    https://leetcode.com/problems/integer-replacement/

    /*
    Given a positive integer n, you can apply one of the following operations:

    If n is even, replace n with n / 2.
    If n is odd, replace n with either n + 1 or n - 1.
    Return the minimum number of operations needed for n to become 1.

     */


    // recursive
    // java.lang.StackOverflowError
    public int integerReplacement_recursive_failed(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + integerReplacement_recursive_failed(n / 2);
        } else {
            return 1 + Math.min(integerReplacement_recursive_failed(n + 1), integerReplacement_recursive_failed(n - 1));
        }
    }

    public int integerReplacement_recursive(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + integerReplacement_recursive(n / 2);
        } else {
            return 2 + Math.min(integerReplacement_recursive(n/2), integerReplacement_recursive(n/2 + 1));
        }

    }


    public static void main(String[] args) {
        IntegerReplacement solution = new IntegerReplacement();
        int n = 8;
        int steps = solution.integerReplacement_recursive(n);
        System.out.println("Steps needed to convert " + n + " to 1: " + steps); // Output: 3
    }

}
