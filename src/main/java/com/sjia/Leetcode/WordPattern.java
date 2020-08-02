package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // #290 https://leetcode.com/problems/word-pattern/

    // similar to #205

    // Runtime: 1 ms, faster than 68.11% of Java online submissions for Word Pattern.
    //Memory Usage: 38.9 MB, less than 5.33% of Java online submissions for Word Pattern.
/*
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        HashMap<Character, String> tmp =new HashMap<>();
        for (int i=0; i < pattern.length(); i++) {
            if( tmp.containsKey(pattern.charAt(i)) ) {
                if( !tmp.get(pattern.charAt(i)).equals(words[i]) ) return false;
            } else {
                if (tmp.containsValue(words[i]) ) return false;
                else tmp.put(pattern.charAt(i), words[i] );
            }
        }
        return true;
    }*/

    // Map both to Integer
    //Runtime: 1 ms, faster than 68.11% of Java online submissions for Word Pattern.
    //Memory Usage: 37.6 MB, less than 18.94% of Java online submissions for Word Pattern.

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");

        if (words.length != pattern.length())
            return false;
        HashMap<Character, Integer> tmp1 =new HashMap<>();
        HashMap<String, Integer> tmp2 =new HashMap<>();
        for (int i=0; i < pattern.length(); i++) {
            int a = tmp1.getOrDefault(pattern.charAt(i),-1);
            int b = tmp2.getOrDefault(words[i],-1);
            if (a != b) return false;
            else {
                tmp1.put(pattern.charAt(i), i);
                tmp2.put(words[i], i);
            }
        }
        return true;
    }




}
