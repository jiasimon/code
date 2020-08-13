package com.sjia.Leetcode;

public class FibonacciNumber {

    // #509 https://leetcode.com/problems/fibonacci-number/
    // refer to #62, 70 ,91

    // recursive
    // Runtime: 6 ms, faster than 32.51% of Java online submissions for Fibonacci Number.
    //Memory Usage: 36.3 MB, less than 54.46% of Java online submissions for Fibonacci Number.
/*
    public int fib(int N) {
        if (N <=1) return N;
        return fib(N-1) + fib(N-2);
    }*/



    //iterative, faster than recursive
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
    //Memory Usage: 36.1 MB, less than 77.98% of Java online submissions for Fibonacci Number.
    public int fib(int N) {
        if (N <=1) return N;
        int prev=0, pre=1, current=0;
        for (int i=2; i<=N; i++) {
            current = prev + pre;
            prev = pre;
            pre = current;
        }
        return current;
    }


}
