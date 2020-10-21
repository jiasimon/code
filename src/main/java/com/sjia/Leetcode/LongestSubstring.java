package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    // #3 https://leetcode.com/problems/longest-substring-without-repeating-characters/
    // 0 <= s.length <= 5 * 104
    // s consists of English letters, digits, symbols and spaces.
    // abcbc
    // pwwkew


    // HashSet,  j: right side; i: left side
    // Runtime: 7 ms, faster than 53.49% of Java online submissions for Longest Substring Without Repeating Characters.
    // Memory Usage: 39.5 MB, less than 5.69% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, res = 0;
        Set<Character> tmp = new HashSet<>();
        while ( j < s.length()) {
            if ( !tmp.contains(s.charAt(j))) {
                tmp.add(s.charAt(j));
                j++;
                res = Math.max(res, tmp.size());
            } else {
                tmp.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }



/*
    static int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }*/

    public static void main(String[] args) {
        String testData = "pwwkewo";
        int result = lengthOfLongestSubstring(testData);
        System.out.println("The length of substring without repeating characters is: " + result);

    }
}
