package com.sjia.hackerRank2026;

public class RepeatedString {
    // https://www.hackerrank.com/challenges/repeated-string/problem

    public static long repeatedString(String s, long n) {
        // Count 'a' in the single original string
        long countInSingleString = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countInSingleString++;
            }
        }

        // Find how many full times the string repeats within n characters
        long fullRepeats = n / s.length();
        long totalCount = fullRepeats * countInSingleString;

        // Count 'a' in the remaining fractional part
        long remainder = n % s.length();
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                totalCount++;
            }
        }

        return totalCount;
    }

}
