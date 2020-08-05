package com.sjia.Leetcode;

public class FirstUniqueCharacter {

    // #387 https://leetcode.com/problems/first-unique-character-in-a-string/

    // Runtime: 6 ms, faster than 91.75% of Java online submissions for First Unique Character in a String.
    //Memory Usage: 39.8 MB, less than 67.42% of Java online submissions for First Unique Character in a String.
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

}
