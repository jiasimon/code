package com.sjia.Leetcode;

public class VerifyAlienDictionary {
    // #953 https://leetcode.com/problems/verifying-an-alien-dictionary/

    // Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    // Output: true
    // Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
    // Output: false

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Verifying an Alien Dictionary.
    //Memory Usage: 37.4 MB, less than 99.21% of Java online submissions for Verifying an Alien Dictionary.
    public boolean isAlienSorted(String[] words, String order) {
        int[] tmp = new int[26];
        for (int i=0; i< order.length(); i++) {
            tmp[order.charAt(i) - 'a'] = i;
        }
        for (int i=1; i< words.length; i++) {
            if ( notInOrder(words[i-1], words[i], tmp) ) return false;
        }
        return true;

    }

    private boolean notInOrder(String word1, String word2, int[] map) {
        int a=word1.length(), b=word2.length();
        for (int i=0; i< Math.min(a,b); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return map[word1.charAt(i) - 'a'] - map[word2.charAt(i) - 'a'] >0;
            }
        }
        return a > b;
    }


}
