package com.sjia.Leetcode;

import java.util.*;

public class FindAllAnagrams438 {
    // #438. Find All Anagrams in a String   https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

    /*
    Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Input: s = "cbaebabacd", p = "abc"      Output: [0,6]
    Input: s = "abab", p = "ab"             Output: [0,1,2]

    1 <= s.length, p.length <= 3 * 10000
    s and p consist of lowercase English letters.
     */



    // sliding window, Map
    // 28 ms, 49.63%; 45.2 MB, 15.4%
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // Create frequency maps for the pattern string (p) and the current window in s
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while (right < s.length()) {
            char charRight = s.charAt(right);

            // Expand the window by moving the right pointer
            if (patternMap.containsKey(charRight)) {
                windowMap.put(charRight, windowMap.getOrDefault(charRight, 0) + 1);

                if (windowMap.get(charRight).equals(patternMap.get(charRight))) {
                    count++;
                }
            }

            right++;

            // Contract the window by moving the left pointer
            while (count == patternMap.size()) {
                // Check if the current window is an anagram
                if (right - left == p.length()) {
                    result.add(left);
                }

                char charLeft = s.charAt(left);

                if (patternMap.containsKey(charLeft)) {
                    windowMap.put(charLeft, windowMap.get(charLeft) - 1);

                    if (windowMap.get(charLeft) < patternMap.get(charLeft)) {
                        count--;
                    }
                }

                left++;
            }
        }

        return result;
    }




    public static void main(String[] args) {
        FindAllAnagrams438 solution = new FindAllAnagrams438();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagramIndices = solution.findAnagrams(s, p);
        System.out.println("Anagram Indices: " + anagramIndices); // Output: [0, 6]
    }


}
