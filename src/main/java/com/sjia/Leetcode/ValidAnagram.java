package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidAnagram {
    // #242 https://leetcode.com/problems/valid-anagram/

    // Arrays.equals
    // Runtime: 2 ms, faster than 97.37% of Java online submissions for Valid Anagram.
    //Memory Usage: 39.4 MB, less than 66.28% of Java online submissions for Valid Anagram.
/*
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }*/

    // HashMap 
    // Runtime: 21 ms, faster than 11.72% of Java online submissions for Valid Anagram.
    //Memory Usage: 39.8 MB, less than 33.14% of Java online submissions for Valid Anagram.
    public boolean isAnagram(String s, String t) {
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



    public static void main(String[] args) {

        String s = "太阳雨";
        String t = "雨太阳";
        ValidAnagram solution = new ValidAnagram();
        boolean result = solution.isAnagram(s,t);
        System.out.printf(" %s and %s anagram is : %s  \n", s, t, result);
    }

}
