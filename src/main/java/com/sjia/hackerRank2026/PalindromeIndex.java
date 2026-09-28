package com.sjia.hackerRank2026;

public class PalindromeIndex {
    // https://www.hackerrank.com/challenges/palindrome-index/problem?isFullScreen=true

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // If characters match, move pointers closer to the center
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // If they don't match, check which index's removal forms a palindrome
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                // If neither forms a palindrome, it's impossible (though problem implies a solution exists)
                return -1;
            }
        }

        // The string is already a palindrome
        return -1;
    }

    // Helper method to check if a substring is a valid palindrome
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
