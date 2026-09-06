package com.sjia.hackerRank2026;

public class FlippingBits {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-flipping-bits

    public static long flippingBits(long n) {
        // Bitwise NOT inverts all bits.
        // Mask with 0xFFFFFFFFL to keep only the lower 32 bits as an unsigned long.
        return (~n) & 0xFFFFFFFFL;
    }

    public static long flippingBitsByAdd(long n) {
        long inverted = ~(int) n; // Cast to 32-bit int and invert

        if (inverted < 0) {
            // Add 2^32 to convert the negative signed integer to an unsigned long
            inverted += (1L << 32);
        }

        return inverted;
    }

    public static long flippingBitsToUnsignedLong(long n) {
        int inverted = ~(int) n;
        return Integer.toUnsignedLong(inverted);
    }

    public static long flippingBitsByMinus(long n) {
        return 4294967295L - n;
    }

}
