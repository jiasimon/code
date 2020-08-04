package com.sjia.Leetcode;

public class PowerofFour {

    // #342 https://leetcode.com/problems/power-of-four/


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


    // bit
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
    //Memory Usage: 36.6 MB, less than 53.98% of Java online submissions for Power of Four.
/*    public boolean isPowerOfFour(int num) {

        return ( num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0 );
    }*/

}
