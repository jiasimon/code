package com.sjia.Leetcode;

public class BinaryAlternatingBits {
    // #693 https://leetcode.com/problems/binary-number-with-alternating-bits/
    // 1010(10), true;  101(5), true

    // #bit , right shift 1
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Number with Alternating Bits.
    //Memory Usage: 36 MB, less than 88.40% of Java online submissions for Binary Number with Alternating Bits.
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >>1) ;
        return (n & (n+1) ) ==0;
    }


    


}
