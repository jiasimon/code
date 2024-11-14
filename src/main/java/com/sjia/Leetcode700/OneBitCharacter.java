package com.sjia.Leetcode700;

public class OneBitCharacter {
    // #717. 1-bit and 2-bit Characters     https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
    /*


    Traverse the array from left to right.
    If we encounter a 1, it means the current character is a 2-bit character (10 or 11), so we skip the next bit.
    If we encounter a 0, it means the current character is a 1-bit character.
    The last character can only be a 1-bit character if we reach it without skipping it due to a preceding 1.
     */

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;

        // Traverse the array
        while (i < n - 1) {
            // If we encounter a '1', skip the next bit (since it's a 2-bit character)
            if (bits[i] == 1) {
                i += 2;
            } else {
                // If it's '0', move to the next bit
                i++;
            }
        }

        // Check if we stopped at the last index
        return i == n - 1;
    }


    public static void main(String[] args) {
        OneBitCharacter solution = new OneBitCharacter();

        // Test Case 1
        int[] bits1 = {1, 0, 0};
        System.out.println(solution.isOneBitCharacter(bits1)); // Output: true

        // Test Case 2
        int[] bits2 = {1, 1, 1, 0};
        System.out.println(solution.isOneBitCharacter(bits2)); // Output: false

        // Test Case 3
        int[] bits3 = {0};
        System.out.println(solution.isOneBitCharacter(bits3)); // Output: true
    }



}
