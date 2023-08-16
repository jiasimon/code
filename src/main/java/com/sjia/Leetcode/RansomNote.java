package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // #383. Ransom Note    https://leetcode.com/problems/ransom-note/

    /*
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

    Each letter in magazine can only be used once in ransomNote.

    Input: ransomNote = "a", magazine = "b"     Output: false
    Input: ransomNote = "aa", magazine = "aab"  Output: true

    1 <= ransomNote.length, magazine.length <= 10^5
    ransomNote and magazine consist of lowercase English letters.
     */


    // one hashmap
    // 10 ms, 62.17%; 44 MB, 51.87%
    public boolean canConstruct_OneHashMap(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> letterCount = new HashMap<>() ;

        for (char c : magazine.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        // Check if the ransom note can be constructed

        for (char c : ransomNote.toCharArray()) {
            if (!letterCount.containsKey(c) || letterCount.get(c) == 0) {
                return false;
            }
            letterCount.put(c, letterCount.get(c) - 1);
        }

        return true;

    }



    // Twp maps
    // 14 ms, 53.99%; 44.4 MB, 12.57%
    public boolean canConstruct2(String ransomNote, String magazine) {
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




    // Runtime: 8 ms, faster than 46.60% of Java online submissions for Ransom Note.
    //Memory Usage: 42.6 MB, less than 5.02% of Java online submissions for Ransom Note.
/*
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] r = new int[128];
        int[] m = new int[128];

        for( int i=0; i < ransomNote.length(); i++ ) {
            r[ransomNote.charAt(i)  ] += 1;
        }

        for (int i=0; i <magazine.length(); i++ ) {
            m[magazine.charAt(i)  ] += 1;
        }

        for (int i=0; i < ransomNote.length(); i++ ) {
            if (r[ransomNote.charAt(i)] >  m[ransomNote.charAt(i)] ) return false;
        }
        return true;
    }*/



    // Runtime: 3 ms, faster than 84.41% of Java online submissions for Ransom Note.
    //Memory Usage: 43.1 MB, less than 5.02% of Java online submissions for Ransom Note.
    public boolean canConstruct_array(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] m = new int[26];

        for (int i=0; i <magazine.length(); i++ ) {
            m[magazine.charAt(i) - 'a' ] += 1;
        }

        for (int i=0; i < ransomNote.length(); i++ ) {
           m[ransomNote.charAt(i) - 'a'] -= 1;
           if (m[ransomNote.charAt(i) - 'a'] <0) {
               return false;
           }
        }
        return true;
    }


    public static void main(String[] args) {


        String ransomNote  = "aabb";
        String magazine = "aab";
        RansomNote solution = new RansomNote();
        boolean result = solution.canConstruct2(ransomNote, magazine);

        System.out.printf("ransomNote: %s  and magazine %s canConstruct %s \n",
                ransomNote,magazine, result);
    }

}
