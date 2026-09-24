package com.sjia.hackerRank2026;

public class HackerRankInString {
    // https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem?isFullScreen=true

    public static String hackerrankInString(String s) {
        String target = "hackerrank";
        int targetPointer = 0;

        // Traverse the given string to look for consecutive subsequence characters
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target.charAt(targetPointer)) {
                targetPointer++;
            }

            // If we matched all characters of "hackerrank", we can stop early
            if (targetPointer == target.length()) {
                return "YES";
            }
        }

        return "NO";
    }

}
