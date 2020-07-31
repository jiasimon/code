package com.sjia.Leetcode;

import java.util.Arrays;

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

}
