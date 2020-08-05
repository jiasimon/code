package com.sjia.Leetcode;

public class PalindromeLongest {

    // #409 https://leetcode.com/problems/longest-palindrome/
    // Given a string which consists of lowercase or uppercase letters,
    // find the length of the longest palindromes that can be built with those letters.


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

}
