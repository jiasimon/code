package com.sjia.Leetcode;

public class PowerofTwo {
    // #231. Power of Two https://leetcode.com/problems/power-of-two/
    /*
    Given an integer n, return true if it is a power of two. Otherwise, return false.

    An integer n is a power of two, if there exists an integer x such that n == 2x.

    Input: n = 16   Output: true
    Input: n = 3    Output: false
     */

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Two.
    //Memory Usage: 36.9 MB, less than 11.45% of Java online submissions for Power of Two.

    public boolean isPowerOfTwoBitCount(int n) {
        if (n<=0) return false;
        else return Integer.bitCount(n)==1 ;
    }

    // Runtime: 2 ms, faster than 40.55% of Java online submissions for Power of Two.
    //Memory Usage: 38.7 MB, less than 5.42% of Java online submissions for Power of Two.
/*
    public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }*/


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Two.
    //Memory Usage: 36.4 MB, less than 79.52% of Java online submissions for Power of Two.

    // n & (n-1), remove most right side "1" in bit
    public boolean isPowerOfTwo(int n) {
        if (n <=0 ) return false;
        return ( n & (n-1)) == 0;
    }


}
