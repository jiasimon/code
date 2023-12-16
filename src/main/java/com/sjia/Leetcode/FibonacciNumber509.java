package com.sjia.Leetcode;

public class FibonacciNumber509 {
    // #509. Fibonacci Number   https://leetcode.com/problems/fibonacci-number/description/

    /*
    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.
    Given n, calculate F(n).

    0 <= n <= 30
     */

    //
    // 8 ms, 21.39%; 40.2 MB, 6.35%
    public int fib_recursive(int N) {
        if (N <=1 && N >=0 ) return N;
        return fib_recursive(N-1) + fib_recursive(N-2);

    }


    public static void main(String[] args) {
        FibonacciNumber solution = new FibonacciNumber();

        int n = 7;

        int nthFibonacci = solution.fib(n);
        System.out.println("The " + n + "th Fibonacci number is: " + nthFibonacci);
    }


}
