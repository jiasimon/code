package com.sjia.Leetcode;

public class PowerofThree {
    // #326. Power of Three  https://leetcode.com/problems/power-of-three/
    /*
    Given an integer n, return true if it is a power of three. Otherwise, return false.

    An integer n is a power of three, if there exists an integer x such that n == 3x.

    Input: n = 27   Output: true
    Input: n = 0    Output: false
    Input: n = -1   Output: false
     */

    // Runtime: 11 ms, faster than 87.09% of Java online submissions for Power of Three.
    //Memory Usage: 39.4 MB, less than 16.95% of Java online submissions for Power of Three.
    public boolean isPowerOfThree(int n) {
        if (n<=0) {
            return false;
        }
        while ( n>=3) {
            if(n%3 != 0) return false;
            n /= 3;
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


    public static void main(String[] args) {
        PowerofThree solution = new PowerofThree();
        int n = 27;
        System.out.println(solution.isPowerOfThree(n)); // Output: true (3^3 = 27)
    }


}
