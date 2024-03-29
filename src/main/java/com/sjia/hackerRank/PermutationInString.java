package com.sjia.hackerRank;

import java.util.Arrays;

public class PermutationInString {
    // #567. Permutation in String  https://leetcode.com/problems/permutation-in-string/description/

    /*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.

    Input: s1 = "ab", s2 = "eidbaooo"   Output: true
    Input: s1 = "ab", s2 = "eidboaoo"   Output: false

    1 <= s1.length, s2.length <= 10^4
    s1 and s2 consist of lowercase English letters.
     */

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println("Test Case 1: " + solution.checkInclusion(s1, s2)); // Output: true
    }

}
