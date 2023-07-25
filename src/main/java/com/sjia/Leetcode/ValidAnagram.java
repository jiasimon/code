package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidAnagram {
    // #242 https://leetcode.com/problems/valid-anagram/

    // Arrays.equals, sort
    // Runtime: 2 ms, faster than 97.37% of Java online submissions for Valid Anagram.
    //Memory Usage: 39.4 MB, less than 66.28% of Java online submissions for Valid Anagram.
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // HashMap
    // Runtime: 21 ms, faster than 11.72% of Java online submissions for Valid Anagram.
    //Memory Usage: 39.8 MB, less than 33.14% of Java online submissions for Valid Anagram.
    public boolean isAnagramHashMap(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> tmp = new HashMap<>();
        for (int i=0; i < s.length(); i++) {
            tmp.put(s.charAt(i), tmp.getOrDefault(s.charAt(i),0)+1);
            tmp.put(t.charAt(i), tmp.getOrDefault(t.charAt(i),0)-1);
        }
        for( char c : tmp.keySet()) {
            if (tmp.get(c) !=0 ) return false;
        }
        return true;
    }



    // int[26] , lowercase English letters.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charFrequency = new int[26];

        // Count character frequencies in the first string
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }

        // Decrement character frequencies for the second string
        for (char c : t.toCharArray()) {
            charFrequency[c - 'a']--;
        }

        // Check if all character frequencies are zero (both strings have the same characters)
        for (int freq : charFrequency) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }



    // two int[26], Count[ch - 'a']
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        ValidAnagram solution = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";
        System.out.println("Are strings valid anagrams? " + solution.isAnagram(s, t)); // Output: true

        s = "rat";
        t = "car";
        System.out.println("Are strings valid anagrams? " + solution.isAnagram(s, t)); // Output: false


        // int[26] fail on UTF char
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 22729 out of bounds for length 26
/*
        s = "太阳雨";
        t = "雨太阳";

        boolean result = solution.isAnagram(s,t);
        System.out.printf(" %s and %s anagram is : %s  \n", s, t, result);
*/

    }

}
