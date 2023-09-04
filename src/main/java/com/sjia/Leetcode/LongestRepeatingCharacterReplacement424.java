package com.sjia.Leetcode;

public class LongestRepeatingCharacterReplacement424 {
    // #424. Longest Repeating Character Replacement    https://leetcode.com/problems/longest-repeating-character-replacement/description/
    // bytedance interview

    /*
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.

    Input: s = "ABAB", k = 2        Output: 4
    Input: s = "AABABBA", k = 1     Output: 4

    1 <= s.length <= 100000
    s consists of only uppercase English letters.
    0 <= k <= s.length
     */


    // sliding window
    // end-start+1 = size of the current window
    // maxCount = largest count of a single, unique character in the current window
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement424 solution = new LongestRepeatingCharacterReplacement424();
        String s = "ACABCC";   //  ABAB, CCCABABCC ,
        int k = 2;
        int maxLen = solution.characterReplacement(s, k);
        System.out.println("Maximum repeating character replacement length: " + maxLen); // Output: 4
    }


}
