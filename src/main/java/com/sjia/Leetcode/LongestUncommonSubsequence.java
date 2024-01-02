package com.sjia.Leetcode;

public class LongestUncommonSubsequence {
    // #521. Longest Uncommon Subsequence I     https://leetcode.com/problems/longest-uncommon-subsequence-i/

    /*
    An uncommon subsequence between two strings is a string that is a subsequence of one but not the other.

    A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

    For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).

    Input: a = "aba", b = "cdc"     Output: 3
    Input: a = "aaa", b = "bbb"     Output: 3
    Input: a = "aaa", b = "aaa"     Output: -1

    1 <= a.length, b.length <= 100
    a and b consist of lower-case English letters.

     */

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1; // There is no uncommon subsequence if both strings are equal
        } else {
            return Math.max(a.length(), b.length()); // Return the length of the longer string
        }
    }

    public static void main(String[] args) {
        LongestUncommonSubsequence solution = new LongestUncommonSubsequence();

        String a = "abc";
        String b = "cdc";

        int length = solution.findLUSlength(a, b);
        System.out.println("Length of the longest uncommon subsequence: " + length);
    }


}
