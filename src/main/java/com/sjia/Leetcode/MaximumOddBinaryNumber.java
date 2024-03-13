package com.sjia.Leetcode;

public class MaximumOddBinaryNumber {
    // #2864. Maximum Odd Binary Number     https://leetcode.com/problems/maximum-odd-binary-number/description/
    /*
    You are given a binary string s that contains at least one '1'.

    You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.

    Return a string representing the maximum odd binary number that can be created from the given combination.

    Note that the resulting string can have leading zeros.

    Input: s = "010"    Output: "001"

    Input: s = "0101"   Output: "1001"

    1 <= s.length <= 100
    s consists only of '0' and '1'.
     */

    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for (int i =0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int zeros = s.length() - ones;

        // JDK11
        return "1".repeat(ones - 1) + "0".repeat(zeros) + "1";

    }


    

}
