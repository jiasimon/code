package com.sjia.Leetcode;

public class FindClosestPalindrome {
    // #564. Find the Closest Palindrome    https://leetcode.com/problems/find-the-closest-palindrome/description/
    /*
    Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

    The closest is defined as the absolute difference minimized between two integers.

    Input: n = "123"        Output: "121"

    Input: n = "1"          Output: "0"
     */

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long smaller = getSmallerPalindrome(num);
        long larger = getLargerPalindrome(num);

        return String.valueOf(num - smaller <= larger - num ? smaller : larger);
    }

    private long getSmallerPalindrome(long num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len / 2; i++) {
            chars[len - 1 - i] = chars[i];
        }

        long smaller = Long.parseLong(String.valueOf(chars));
        return smaller < num ? smaller : (long)Math.pow(10, len - 1) - 1;
    }

    private long getLargerPalindrome(long num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len / 2; i++) {
            chars[len - 1 - i] = chars[i];
        }

        long larger = Long.parseLong(String.valueOf(chars));
        return larger > num ? larger : (long)Math.pow(10, len) + 1;
    }


        public static void main(String[] args) {
            FindClosestPalindrome solution = new FindClosestPalindrome();

            String testInput = "99";
            System.out.println("Test Case 1: " + solution.nearestPalindromic(testInput)); // Output: "101"

            String testInput2 = "101";
            System.out.println("Test Case 1: " + solution.nearestPalindromic(testInput2)); // Output: "99"


        }


}
