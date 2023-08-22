package com.sjia.Leetcode;

public class LongestSubstringKRepeatingChar {
    // #395. Longest Substring with At Least K Repeating Characters
    // https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

    /*
    Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

    if no such substring exists, return 0.

    Input: s = "aaabb", k = 3   Output: 3
    Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

    Input: s = "ababbc", k = 2  Output: 5
    Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     */


    // recursive
    // 80 ms, 21.98%; 44.8 MB, 5.30%
    public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        for ( int i =0; i < s.length(); i++ ) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i =0; i < s.length(); i++ ) {
            if (count[s.charAt(i)-'a'] < k) {
                int l = longestSubstring(s.substring(0,i), k);
                int r = longestSubstring(s.substring(i+1, s.length()), k);
                return Math.max(l,r);
            }
        }
        return s.length();

    }


    public static void main(String[] args) {
        LongestSubstringKRepeatingChar solution = new LongestSubstringKRepeatingChar();
        String s = "aaabb";
        int k = 3;
        int longestLen = solution.longestSubstring(s, k);
        System.out.println("Length of the longest substring: " + longestLen); // Output: 3
    }


}
