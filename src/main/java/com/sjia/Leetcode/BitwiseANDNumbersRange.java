package com.sjia.Leetcode;

public class BitwiseANDNumbersRange {
    // #201. Bitwise AND of Numbers Range   https://leetcode.com/problems/bitwise-and-of-numbers-range/
    /*
    https://leetcode.com/problems/bitwise-and-of-numbers-range/
    Input: left = 5, right = 7      Output: 4
    Input: left = 0, right = 0      Output: 0
    Input: left = 1, right = 2147483647 Output: 0

    Note: this problem is asking us to find the common prefix of m and n 's binary code.
     */


    // 6ms, 100.00% ; 42.63mb, 87.56%
    public int rangeBitwiseAnd(int left, int right) {
        int shift =0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift ;

    }



}
