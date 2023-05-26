package com.sjia.Leetcode;

import java.util.*;

public class LongestSubstring {
    // #3 https://leetcode.com/problems/longest-substring-without-repeating-characters/
    // 0 <= s.length <= 5 * 104
    // s consists of English letters, digits, symbols and spaces.
    // abcbc
    // pwwkew


    // HashSet,  j: right side; i: left side
    // Runtime: 7 ms, faster than 53.49% of Java online submissions for Longest Substring Without Repeating Characters.
    // Memory Usage: 39.5 MB, less than 5.69% of Java online submissions for Longest Substring Without Repeating Characters.
    public static int lengthOfLongestSubstring(String s) {
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

    // Runtime: 8 ms, faster than 37.45% of Java online submissions for Longest Substring Without Repeating Characters.
    //Memory Usage: 39.8 MB, less than 5.69% of Java online submissions for Longest Substring Without Repeating Characters.
/*    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, res = 0;
        Set<Character> tmp = new HashSet<>();
        while ( j < s.length()) {
            if ( !tmp.contains(s.charAt(j))) {
                tmp.add(s.charAt(j++));
                res = Math.max(res, tmp.size());
            } else {
                tmp.remove(s.charAt(i++));
            }
        }
        return res;
    }*/


    // HashMap get duplicate char position , then +1
    // Runtime: 4 ms, faster than 90.72% of Java online submissions for Longest Substring Without Repeating Characters.
    // Memory Usage: 39 MB, less than 5.69% of Java online submissions for Longest Substring Without Repeating Characters.

/*
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2 ) return s.length();
        int j = 0, res = 0;
        Map<Character, Integer> tmp = new HashMap<>();
        for (int i=0; i< s.length(); i++) {
            if (  tmp.containsKey(s.charAt(i))) {
                j = Math.max( j, tmp.get(s.charAt(i)) + 1);
            }
            tmp.put(s.charAt(i),i);
            res = Math.max(res, i-j+1);
        }
        return res;
    }

*/



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
