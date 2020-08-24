package com.sjia.Leetcode;

public class Char717 {
    // #717 https://leetcode.com/problems/1-bit-and-2-bit-characters/
    // The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
    //
    //Now given a string represented by several bits.
    // Return whether the last character must be a one-bit character or not.
    // The given string will always end with a zero.


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for 1-bit and 2-bit Characters.
    //Memory Usage: 40.6 MB, less than 15.44% of Java online submissions for 1-bit and 2-bit Characters.
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, count=0;
        if (n==1) return true;
        if (bits[n-2] == 0) return true;
        for (int i=n-2; i>=0 && bits[i]==1; i--) {
            count++;
        }
        if (count % 2 >0 ) return false;
        return true;
    }




}
