package com.sjia.Leetcode;

public class ReverseBits {
    // #190. Reverse Bits   https://leetcode.com/problems/reverse-bits/
    /*
    Reverse bits of a given 32 bits unsigned integer.
    Input : unsigned integer 43261596
    Input: n = 00000010100101000001111010011100     Output:    964176192 (00111001011110000010100101000000)
    so return 964176192 which its binary representation is 00111001011110000010100101000000.
     */



    // String reverse
    // 2ms, 6.19%; 41.04mb, 46.97%
    public int reverseBitsByString(int n) {
        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toBinaryString(n));  // 10100101000001111010011100
        sb.reverse();  // 00111001011110000010100101
        // fix leading/tailing zeros

//        sb.append("0".repeat(32 - sb.length()));  // need JDK 11

//        for (int i=0; i< 32 - sb.length(); i++ ) {     // incorrect, sb length changed after append, impact loop

        int count = 32 - sb.length();
        for (int i=0; i < count; i++ ) {
            sb.append("0");
        }


        // parse the binary string back to unsigned int
        return Integer.parseUnsignedInt(sb.toString(), 2);

    }



    // Integer.reverse
    // 1ms, 96.40%; 40.88mb, 72.05%
    public int reverseBitsByInteger(int num) {
        return Integer.reverse(num);

        /*
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);

        return num;
         */

    }


    // bit operation,
    public int reverseBits(int n) {
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }


    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        // Test case
        int n = 43261596;
        int reversedBits = solution.reverseBitsByInteger(n);
        System.out.println("Reversed Bits: " + reversedBits);  // Expected output: 964176192
    }

}
