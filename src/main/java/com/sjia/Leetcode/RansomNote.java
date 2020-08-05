package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // #383 https://leetcode.com/problems/ransom-note/

    // Runtime: 32 ms, faster than 9.31% of Java online submissions for Ransom Note.
    //Memory Usage: 49.6 MB, less than 5.02% of Java online submissions for Ransom Note.
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> r = new HashMap<>();
        Map<Character, Integer> m = new HashMap<>();

        for( char c : ransomNote.toCharArray() ) {
            r.put(c, r.getOrDefault(c,0)+ 1);
        }

        for (char c : magazine.toCharArray()) {
            m.put(c, m.getOrDefault(c,0)+1);
        }

        for (char key : r.keySet()) {
            if (r.get(key) >  m.getOrDefault(key,0)) return false;
        }
        return true;

    }

}
