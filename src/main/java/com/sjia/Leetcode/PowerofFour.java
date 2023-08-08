package com.sjia.Leetcode;

public class PowerofFour {

    // #342. Power of Four https://leetcode.com/problems/power-of-four/
    /*
    Given an integer n, return true if it is a power of four. Otherwise, return false.

    An integer n is a power of four, if there exists an integer x such that n == 4x.
     */


    // Loop
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
    //Memory Usage: 36.7 MB, less than 30.09% of Java online submissions for Power of Four.
    public boolean isPowerOfFour(int num) {
        while ( num%4 == 0 && num>0){
            num /=4;
        }
        return num==1;
    }


    // Without Loop
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
    //Memory Usage: 37.2 MB, less than 7.96% of Java online submissions for Power of Four.
/*
    public boolean isPowerOfFour(int num) {
        return (Math.log10(num) / Math.log10(4)) % 1 == 0;
    }*/




    // 1ms, 95.93%; 39.20mb, 97.00%
    public boolean isPowerOfFour2(int n) {
        if ( n <= 0) return false;
        while ( n >=4) {
            if (n%4 !=0) {
                return false;
            } else {
                n /= 4;
            }
        }
        return n==1;
    }


    // bit
    // 0ms, 100%; 39.2 MB, 96.94%
    public boolean isPowerOfFour_bit(int num) {
        // num & (num-1)) == 0 ,  Power of two, refer #231
        return ( num > 0 && (num & (num-1)) == 0 && (num %3 ==1 ) );
//        return ( num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0 );
    }




    public static void main(String[] args) {
        PowerofFour solution = new PowerofFour();
        int num = 16;
        System.out.println(solution.isPowerOfFour(num)); // Output: true (4^2 = 16)
    }


}
