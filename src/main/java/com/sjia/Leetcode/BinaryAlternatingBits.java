package com.sjia.Leetcode;

public class BinaryAlternatingBits {
    // #693 https://leetcode.com/problems/binary-number-with-alternating-bits/
    // 1010(10), true;  101(5), true

    // #bit , right shift 1
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Number with Alternating Bits.
    //Memory Usage: 36 MB, less than 88.40% of Java online submissions for Binary Number with Alternating Bits.
/*
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >>1) ;
        return (n & (n+1) ) ==0;
    }*/



    // regex,
    // Runtime: 6 ms, faster than 7.47% of Java online submissions for Binary Number with Alternating Bits.
    //Memory Usage: 36.6 MB, less than 46.72% of Java online submissions for Binary Number with Alternating Bits.
/*    public boolean hasAlternatingBits(int n) {
        return Integer.toBinaryString(n).matches("(10)*1?");
    }*/



    // Runtime: 1 ms, faster than 33.60% of Java online submissions for Binary Number with Alternating Bits.
    //Memory Usage: 36.4 MB, less than 59.74% of Java online submissions for Binary Number with Alternating Bits.
/*    public boolean hasAlternatingBits(int n) {
        return  (!Integer.toBinaryString(n).contains("00") ) &&
                (!Integer.toBinaryString(n).contains("11") );
    }*/

}
