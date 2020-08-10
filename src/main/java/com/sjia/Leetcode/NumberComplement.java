package com.sjia.Leetcode;

public class NumberComplement {
    // #476 https://leetcode.com/problems/number-complement/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Number Complement.
    //Memory Usage: 36 MB, less than 88.79% of Java online submissions for Number Complement.
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }

}
