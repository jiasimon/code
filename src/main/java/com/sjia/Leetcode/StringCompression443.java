package com.sjia.Leetcode;

public class StringCompression443 {
    // #443. String Compression https://leetcode.com/problems/string-compression/description/

    /*
    Given an array of characters chars, compress it using the following algorithm:

    Begin with an empty string s. For each group of consecutive repeating characters in chars:

    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
    The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

    After you are done modifying the input array, return the new length of the array.

    You must write an algorithm that uses only constant extra space.

    Input: chars = ["a","a","b","b","c","c","c"]    Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

    Input: chars = ["a"]    Output: Return 1, and the first character of the input array should be: ["a"]

    Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

    1 <= chars.length <= 2000
    chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
     */


    public int compress(char[] chars) {
        int i = 0; // Pointer to the current position in the compressed string
        int count = 1; // Count of consecutive characters
        char currentChar = chars[0]; // Current character to compare with
        int resultIndex = 0; // Pointer to the result array

        for (int j = 1; j < chars.length; j++) {
            if (chars[j] == currentChar) {
                count++; // Increment the count if the character is the same
            } else {
                chars[i++] = currentChar; // Write the character to the result
                if (count > 1) {
                    // If count is greater than 1, write the digits of the count
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[i++] = c;
                    }
                }
                currentChar = chars[j]; // Update the current character
                count = 1; // Reset the count
            }
        }

        // Write the last character and its count if applicable
        chars[i++] = currentChar;
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (char c : countStr.toCharArray()) {
                chars[i++] = c;
            }
        }

        return i; // Return the length of the compressed string
    }

    public static void main(String[] args) {
        StringCompression443 solution = new StringCompression443();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compressedLength = solution.compress(chars);

        System.out.print("Compressed String: ");
        for (int i = 0; i < compressedLength; i++) {
            System.out.print(chars[i]);
        }
        System.out.println(); // Output: "a2b2c3"
    }
}
