package com.sjia.Leetcode600;

public class PalindromicSubstrings {
    // #647. Palindromic Substrings     https://leetcode.com/problems/palindromic-substrings/description/
    /*
    Given a string s, return the number of palindromic substrings in it.

    A string is a palindrome when it reads the same backward as forward.

    A substring is a contiguous sequence of characters within the string.

    Input: s = "abc"    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".

    Input: s = "aaa"    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"
     */


    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindromes(s, i, i); // Odd length palindromes
            count += countPalindromes(s, i, i + 1); // Even length palindromes
        }
        return count;
    }

    private int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }


    public static void main(String[] args) {
        PalindromicSubstrings solution = new PalindromicSubstrings();

        // Test Case
        String s = "abc";
        System.out.println("Test Case 1: " + solution.countSubstrings(s)); // Output: 3
    }

}
