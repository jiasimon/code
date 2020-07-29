package com.sjia.Leetcode;

public class Numberof1Bits {
    // #191 https://leetcode.com/problems/number-of-1-bits/

    // Runtime: 1 ms, faster than 54.21% of Java online submissions for Number of 1 Bits.
    //Memory Usage: 38.8 MB, less than 5.01% of Java online submissions for Number of 1 Bits.

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result = result + (n & 1);
            n = n >>> 1;
        }
        return result;
    }


}
