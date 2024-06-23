package com.sjia.Leetcode600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicDictionary {
    // #676. Implement Magic Dictionary     https://leetcode.com/problems/implement-magic-dictionary/description/
    /*
    Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.

     */


    private Map<String, List<int[]>> dictionary;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        dictionary = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                int[] pair = {i, word.charAt(i)};
                if (!dictionary.containsKey(key)) {
                    dictionary.put(key, new ArrayList<>());
                }
                dictionary.get(key).add(pair);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + "*" + word.substring(i + 1);
            if (dictionary.containsKey(key)) {
                for (int[] pair : dictionary.get(key)) {
                    if (pair[0] == i && pair[1] != word.charAt(i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();

        // Test case 1: Build dictionary and search
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println("Test case 1:");
        System.out.println(magicDictionary.search("hello"));    // Expected output: false
        System.out.println(magicDictionary.search("hhllo"));    // Expected output: true
        System.out.println(magicDictionary.search("hell"));     // Expected output: false
        System.out.println(magicDictionary.search("leetcoded"));// Expected output: false

/*        // Test case 2: Build dictionary with different words and search
        magicDictionary.buildDict(new String[]{"magic", "dictionary"});
        System.out.println("Test case 2:");
        System.out.println(magicDictionary.search("magic"));    // Expected output: false
        System.out.println(magicDictionary.search("mabic"));    // Expected output: true
        System.out.println(magicDictionary.search("dictonary"));// Expected output: false
        System.out.println(magicDictionary.search("dictionory"));// Expected output: true
        */
    }


}
