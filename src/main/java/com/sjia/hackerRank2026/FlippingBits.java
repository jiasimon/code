package com.sjia.hackerRank2026;

public class FlippingBits {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-flipping-bits

    public static long flippingBits(long n) {
        // Bitwise NOT inverts all bits.
        // Mask with 0xFFFFFFFFL to keep only the lower 32 bits as an unsigned long.
        return (~n) & 0xFFFFFFFFL;
    }

    

}
