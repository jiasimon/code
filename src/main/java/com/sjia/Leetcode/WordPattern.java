package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // #290. Word Pattern https://leetcode.com/problems/word-pattern/

    /*
    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
    Input: pattern = "abba", s = "dog cat cat dog"  Output: true
    Input: pattern = "abba", s = "dog cat cat fish" Output: false

    compare to #205
     */


    // Two HashMap
    // 1ms, 61.66% ; 40.25mb, 91.83%
    public boolean TwoMap(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (!charToWord.containsKey(ch) && !wordToChar.containsKey(word)) {
                charToWord.put(ch, word);
                wordToChar.put(word, ch);
            } else {
                if (!charToWord.getOrDefault(ch, "").equals(word) ||
                        wordToChar.getOrDefault(word, (char) 0) != ch) {
                    return false;
                }
            }
        }
        return true;

    }

    // Map both to Integer
    //Runtime: 1 ms, faster than 68.11% of Java online submissions for Word Pattern.
    //Memory Usage: 37.6 MB, less than 18.94% of Java online submissions for Word Pattern.

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");

        if (words.length != pattern.length())
            return false;
        HashMap<Character, Integer> tmp1 = new HashMap<>();
        HashMap<String, Integer> tmp2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            int a = tmp1.getOrDefault(pattern.charAt(i), -1);
            int b = tmp2.getOrDefault(words[i], -1);
            if (a != b) return false;
            else {
                tmp1.put(pattern.charAt(i), i);
                tmp2.put(words[i], i);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        WordPattern solution = new WordPattern();
        boolean result = solution.wordPattern(pattern, s);
        System.out.println("The pattern and string follow the word pattern: " + result); // Output:  true
    }

}
