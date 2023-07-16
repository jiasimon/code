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
    public int reverseBitsString(int n) {
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


    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        // Test case
        int n = 43261596;
        int reversedBits = solution.reverseBitsString(n);
        System.out.println("Reversed Bits: " + reversedBits);  // Expected output: 964176192
    }

}
