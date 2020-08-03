package com.sjia.Leetcode;

public class PowerofThree {
    // #326  https://leetcode.com/problems/power-of-three/

    // Runtime: 11 ms, faster than 87.09% of Java online submissions for Power of Three.
    //Memory Usage: 39.4 MB, less than 16.95% of Java online submissions for Power of Three.
    public boolean isPowerOfThree(int n) {
        if (n<=0) return false;
        while (n >= 3) {
            if (n%3 !=0) return false;
            n /=3;
        }
        return n==1;
    }

    
/*
    public boolean isPowerOfThree(int n) {
        while (n>0 && (n % 3 == 0) ) {
            n /= 3;
        }
        return n == 1;
    }*/



}
