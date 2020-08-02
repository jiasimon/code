package com.sjia.Leetcode;

import java.util.HashMap;

public class IsomorphicStrings {

    // #205  https://leetcode.com/problems/isomorphic-strings/

    // egg:add  foo:bar paper:title good:cooks

    // Runtime: 11 ms, faster than 42.85% of Java online submissions for Isomorphic Strings.
    //Memory Usage: 40.1 MB, less than 5.24% of Java online submissions for Isomorphic Strings.

    // second run, Runtime: 5 ms, faster than 85.54% of Java online submissions for Isomorphic Strings.
    //Memory Usage: 40.7 MB, less than 5.24% of Java online submissions for Isomorphic Strings.
/*
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map1 = new int [256], map2 = new int[256];
        for (int i=0; i<s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)] ) return false;
            else {
                map1[s.charAt(i)] = i + 1;
                map2[t.charAt(i)] = i + 1;
            }
        }
        return true;
    }*/


    // Runtime: 19 ms, faster than 19.09% of Java online submissions for Isomorphic Strings.
    //Memory Usage: 40.6 MB, less than 5.24% of Java online submissions for Isomorphic Strings.

    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> tmp = new HashMap<>();
        for (int i=0; i< s.length(); i++) {
            if( tmp.containsKey(s.charAt(i)) ) {
                if(tmp.get(s.charAt(i)) != t.charAt(i) ) return false;
            } else {
                if (tmp.containsValue(t.charAt(i)) ) return false;
                else tmp.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "good";
        String t = "cooks";
        IsomorphicStrings solution = new IsomorphicStrings();

        boolean result = solution.isIsomorphic(s, t);
        System.out.printf("%s and %s isIsomorphic: %s", s, t, result);

    }

}
