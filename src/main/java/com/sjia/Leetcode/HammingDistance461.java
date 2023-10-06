package com.sjia.Leetcode;

public class HammingDistance461 {
    // #461. Hamming Distance   https://leetcode.com/problems/hamming-distance/
    /*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, return the Hamming distance between them

    Input: x = 1, y = 4     Output: 2
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)

    0 <= x, y <= 231 - 1
     */


    public int hammingDistance(int x, int y) {
        int xorResult = x ^ y;
        int distance = 0;

        // Count the number of set bits in the XOR result
        while (xorResult > 0) {
            if ((xorResult & 1) == 1) {
                distance++;
            }
            xorResult >>= 1; // Right shift to check the next bit
        }

        return distance;
    }

    public static void main(String[] args) {
        HammingDistance461 solution = new HammingDistance461();
        int x = 1;
        int y = 4;

        int distance = solution.hammingDistance(x, y);
        System.out.println("Hamming Distance: " + distance); // Output: 2
    }
}
