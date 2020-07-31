package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class ValidAnagram {
    // #242 https://leetcode.com/problems/valid-anagram/

    // Arrays.equals
    // Runtime: 2 ms, faster than 97.37% of Java online submissions for Valid Anagram.
    //Memory Usage: 39.4 MB, less than 66.28% of Java online submissions for Valid Anagram.
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {

        String s = "太阳雨";
        String t = "雨太阳";
        ValidAnagram solution = new ValidAnagram();
        boolean result = solution.isAnagram(s,t);
        System.out.printf(" %s and %s anagram is : %s  \n", s, t, result);
    }

}
