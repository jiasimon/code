package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromeLongest {

    // #409. Longest Palindrome https://leetcode.com/problems/longest-palindrome/

    /*
        Given a string which consists of lowercase or uppercase letters,
        find the length of the longest palindromes that can be built with those letters.

        Input: s = "abccccdd"       Output: 7
        Input: s = "a"              Output: 1

     */






    // stream anyMatch, slow
    // 4 ms, 69.1%; 41.2 MB, 28.4%
    public int longestPalindrome_stream(String s) {
        int ans = 0;
        int[] count = new int[128];

        for (final char c : s.toCharArray())
            ++count[c];

        for (final int c : count)
            ans += c % 2 == 0 ? c : c - 1;

        final boolean hasOddCount = Arrays.stream(count).anyMatch(c -> c % 2 == 1);

        return ans + (hasOddCount ? 1 : 0);

    }


    // if ( res < n) return res+1;
    // 1 ms, 100%; 40.5 MB, 94.16%
    public int longestPalindrome(String s) {
        int res = 0;
        int[] count = new int[128];

        for (final char c : s.toCharArray())
            ++count[c];

        for (final int c : count) {
            res += c % 2 == 0 ? c : c - 1;
        }


        if ( res < s.length()) return res+1;
        else return res;
    }



    public int longestPalindrome_map(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean oddFrequencyFound = false;

        // Calculate the length of the longest palindrome
        for (int frequency : charFrequency.values()) {
            if (frequency % 2 == 0) {
                length += frequency;
            } else {
                length += frequency - 1;
                oddFrequencyFound = true;
            }
        }

        // Add one extra character if an odd-frequency character exists
        if (oddFrequencyFound) {
            length += 1;
        }

        return length;
    }


    // res += n/2*2;
    // 1ms, 100%; 40.3 MB, 97.32%
    public int longestPalindrome_d2m2(String s) {
        int result =0;
        int[] tmp = new int[128];
        for (char c : s.toCharArray()) {
            tmp[c]  += 1;
        }

        for (int n : tmp) {
            result += n/2*2;
        }
        return result < s.length() ? result+1 : result;
    }


    public static void main(String[] args) {
        PalindromeLongest solution = new PalindromeLongest();
        String s = "abccccdd";
        int longestPalindromeLength = solution.longestPalindrome_stream(s);
        System.out.println("Length of the longest palindrome: " + longestPalindromeLength);
    }

}
