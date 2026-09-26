package com.sjia.hackerRank2026;

public class BeautifulBinaryString {
    // https://www.hackerrank.com/challenges/beautiful-binary-string/problem?isFullScreen=true

    public static int beautifulBinaryString(String b) {
        int count = 0;
        int i = 0;

        // Loop through the string looking for "010"
        while (i <= b.length() - 3) {
            if (b.charAt(i) == '0' && b.charAt(i + 1) == '1' && b.charAt(i + 2) == '0') {
                count++;
                i += 3; // Skip past the fixed "010" substring
            } else {
                i++;
            }
        }

        return count;
    }

    public static int beautifulBinaryString_math(String b) {
        return (b.length() - b.replaceAll("010", "").length()) / 3;
    }
}
