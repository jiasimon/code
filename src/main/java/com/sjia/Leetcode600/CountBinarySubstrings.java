package com.sjia.Leetcode600;

public class CountBinarySubstrings {
    // #696. Count Binary Substrings    https://leetcode.com/problems/count-binary-substrings/description/
    /*
    Input: s = "00110011"   Output: 6
    Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

    Input: s = "10101"      Output: 4
    Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
     */


    public int countBinarySubstrings(String s) {
        int prevGroupLength = 0;
        int currGroupLength = 1;
        int count = 0;

        // Traverse the string to count groups of consecutive 0s and 1s
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroupLength++;  // Increase the current group length if the character is the same as the previous one
            } else {
                // When the current character is different, update the count by comparing the current and previous groups
                count += Math.min(prevGroupLength, currGroupLength);
                prevGroupLength = currGroupLength;  // Set the previous group length to the current one
                currGroupLength = 1;  // Reset the current group length for the new group
            }
        }

        // After the loop, add the remaining valid substrings
        count += Math.min(prevGroupLength, currGroupLength);

        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings solution = new CountBinarySubstrings();

        // Test case 1
        String s1 = "00110011";
        System.out.println("Test case 1: " + solution.countBinarySubstrings(s1)); // Expected output: 6

        // Test case 2
        String s2 = "10101";
        System.out.println("Test case 2: " + solution.countBinarySubstrings(s2)); // Expected output: 4

        // Test case 3
        String s3 = "000111000";
        System.out.println("Test case 3: " + solution.countBinarySubstrings(s3)); // Expected output: 4

        // Test case 4
        String s4 = "1111";
        System.out.println("Test case 4: " + solution.countBinarySubstrings(s4)); // Expected output: 0

        // Test case 5
        String s5 = "10";
        System.out.println("Test case 5: " + solution.countBinarySubstrings(s5)); // Expected output: 1
    }


}