package com.sjia.Leetcode;

import java.util.Arrays;

public class PalindromeLongest {

    // #409. Longest Palindrome https://leetcode.com/problems/longest-palindrome/

    /*
        Given a string which consists of lowercase or uppercase letters,
        find the length of the longest palindromes that can be built with those letters.

        Input: s = "abccccdd"       Output: 7
        Input: s = "a"              Output: 1

     */



    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Palindrome.
    //Memory Usage: 38.2 MB, less than 29.63% of Java online submissions for Longest Palindrome.
    public int longestPalindrome(String s) {
        int[] tmp = new int[128];
        for (char c : s.toCharArray()) {
            tmp[c]  += 1;
        }
        int result =0;
        for (int n : tmp) {
            result += n/2*2;
        }
        return result < s.length() ? result+1 : result;
    }


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


    public static void main(String[] args) {
        PalindromeLongest solution = new PalindromeLongest();
        String s = "abccccdd";
        int longestPalindromeLength = solution.longestPalindrome_stream(s);
        System.out.println("Length of the longest palindrome: " + longestPalindromeLength);
    }

}
