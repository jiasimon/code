package com.sjia.Leetcode;

public class PowerofTwo {
    // #231 https://leetcode.com/problems/power-of-two/

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Two.
    //Memory Usage: 36.9 MB, less than 11.45% of Java online submissions for Power of Two.
/*
    public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        else return Integer.bitCount(n)==1 ;
    }*/

    // Runtime: 2 ms, faster than 40.55% of Java online submissions for Power of Two.
    //Memory Usage: 38.7 MB, less than 5.42% of Java online submissions for Power of Two.
    public boolean isPowerOfTwo(int n) {
        if (n==0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }


}
