package com.sjia.Leetcode;

import java.util.*;

public class FirstUniqueCharacter {

    // #387. First Unique Character in a String https://leetcode.com/problems/first-unique-character-in-a-string/

    /*
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
    Input: s = "leetcode"       Output: 0
    Input: s = "loveleetcode"   Output: 2
     */



    // Map. loop original String
    // 24 ms, 60.45%; 44.2 MB, 44.94%
    public int firstUniqChar_map(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for (int i=0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1 ) {
                return i;
            }
        }
        return -1;
    }


    public int firstUniqChar(String s) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a'] +=1;
        }
        for (int i=0; i < s.length(); i++) {
           if (table[s.charAt(i)- 'a'] == 1) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        FirstUniqueCharacter solution = new FirstUniqueCharacter();
        String s = "leetcode";
        int index = solution.firstUniqChar(s);
        System.out.println("Index of the first unique character: " + index); // Output: 0
    }

}
