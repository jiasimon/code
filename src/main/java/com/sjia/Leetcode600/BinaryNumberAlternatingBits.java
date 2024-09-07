package com.sjia.Leetcode600;

public class BinaryNumberAlternatingBits {
    // #693. Binary Number with Alternating Bits    https://leetcode.com/problems/binary-number-with-alternating-bits/description/
    /*
    Input: n = 5    Output: true
    Explanation: The binary representation of 5 is: 101

    Input: n = 7    Output: false
    Explanation: The binary representation of 7 is: 111.
     */


    // prevBit = n & 1; n >>= 1
    public boolean hasAlternatingBits(int n) {
        int prevBit = n & 1;  // Get the least significant bit
        n >>= 1;  // Right shift n to check the next bit

        while (n > 0) {
            int currBit = n & 1;  // Get the current least significant bit
            if (currBit == prevBit) {
                return false;  // If two consecutive bits are the same, return false
            }
            prevBit = currBit;  // Update the previous bit
            n >>= 1;  // Right shift n to check the next bit
        }
        return true;  // If no consecutive bits are the same, return true
    }

    public static void main(String[] args) {
        BinaryNumberAlternatingBits solution = new BinaryNumberAlternatingBits();

        // Test Case 1
        int n1 = 5;
        System.out.println("Test Case 1: " + solution.hasAlternatingBits(n1)); // Expected output: true (binary: 101)

        // Test Case 2
        int n2 = 7;
        System.out.println("Test Case 2: " + solution.hasAlternatingBits(n2)); // Expected output: false (binary: 111)

        // Test Case 3
        int n3 = 10;
        System.out.println("Test Case 3: " + solution.hasAlternatingBits(n3)); // Expected output: true (binary: 1010)

        // Test Case 4
        int n4 = 11;
        System.out.println("Test Case 4: " + solution.hasAlternatingBits(n4)); // Expected output: false (binary: 1011)

        // Test Case 5
        int n5 = 1;
        System.out.println("Test Case 5: " + solution.hasAlternatingBits(n5)); // Expected output: true (binary: 1)

        // Test Case 6
        int n6 = 2;
        System.out.println("Test Case 6: " + solution.hasAlternatingBits(n6)); // Expected output: true (binary: 10)

        // Test Case 7
        int n7 = 3;
        System.out.println("Test Case 7: " + solution.hasAlternatingBits(n7)); // Expected output: false (binary: 11)
    }


}
