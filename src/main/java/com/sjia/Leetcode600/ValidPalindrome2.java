package com.sjia.Leetcode600;

public class ValidPalindrome2 {
    // #680. Valid Palindrome II    https://leetcode.com/problems/valid-palindrome-ii/description/
    /*
    Given a string s, return true if the s can be palindrome after deleting at most one character from it.

    Input: s = "aba"    Output: true
    Input: s = "abca"   Output: true
     */

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        ValidPalindrome2 solution = new ValidPalindrome2();

        // Test case 1
        String s1 = "abca";
        System.out.println("Test case 1: " + solution.validPalindrome(s1)); // Expected output: true

        // Test case 2
        String s2 = "racecar";
        System.out.println("Test case 2: " + solution.validPalindrome(s2)); // Expected output: true

        // Test case 3
        String s3 = "abcdef";
        System.out.println("Test case 3: " + solution.validPalindrome(s3)); // Expected output: false

        // Test case 4
        String s4 = "deeee";
        System.out.println("Test case 4: " + solution.validPalindrome(s4)); // Expected output: true

        // Test case 5
        String s5 = "abccba";
        System.out.println("Test case 5: " + solution.validPalindrome(s5)); // Expected output: true
    }
}
