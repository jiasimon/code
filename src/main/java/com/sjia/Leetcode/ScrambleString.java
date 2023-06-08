package com.sjia.Leetcode;

public class ScrambleString {
    // #87. Scramble String      https://leetcode.com/problems/scramble-string/
    /*
    We can scramble a string s to get a string t using the following algorithm:

    If the length of the string is 1, stop.
    If the length of the string is > 1, do the following:
    Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
    Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
    Apply step 1 recursively on each of the two substrings x and y.
    Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
     */


    // Input: s1 = "great", s2 = "rgeat"  Output: true
    // Input: s1 = "abcde", s2 = "caebd"  Output: false


    public static boolean isScramble(String s1, String s2) {
        int len = s1.length();

        if (len != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        // dp[i][j][k] represents whether s2[j...j+k] is a scrambled string of s1[i...i+k]
        boolean[][][] dp = new boolean[len][len][len + 1];

        // Initialization: single character comparison
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        // Bottom-up dynamic programming
        for (int k = 2; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                for (int j = 0; j <= len - k; j++) {
                    for (int m = 1; m < k; m++) {
                        // Case 1: no swapping
                        if (dp[i][j][m] && dp[i + m][j + m][k - m]) {
                            dp[i][j][k] = true;
                            break;
                        }

                        // Case 2: swapping
                        if (dp[i][j + k - m][m] && dp[i + m][j][k - m]) {
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][len];
    }

    public static void main(String[] args) {
//        String s1 = "great";
//        String s2 = "rgeat";
        String s1 = "abcde";
        String s2 = "caebd";

        boolean isScrambled = isScramble(s1, s2);
        System.out.println("Is Scramble: " + isScrambled);
    }





}
