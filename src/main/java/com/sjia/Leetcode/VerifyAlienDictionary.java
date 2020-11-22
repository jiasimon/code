package com.sjia.Leetcode;

import java.util.Arrays;

public class VerifyAlienDictionary {
    // #953 https://leetcode.com/problems/verifying-an-alien-dictionary/    #fb

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



    //
    public boolean isAlienSorted2(String[] words, String order) {
        int[] tmp = new int[26];
        for (int i=0; i< order.length(); i++) {
            tmp[order.charAt(i) - 'a'] = i;
        }
        for (int i=1; i< words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];

            int k = Math.min(word1.length(), word2.length());
            boolean flag = false;
            for (int j=0; j < k; j++){
                if( tmp[word1.charAt(j) - 'a'] > tmp[word2.charAt(j) - 'a'] ) {
                    return false;
                } else if ( tmp[word1.charAt(j) - 'a'] < tmp[word2.charAt(j) - 'a'] ) {
                    flag = true;
                    break;
                }
            }
            if (!flag && word1.length() > word2.length()) return false;
        }
        return true;

    }


    public static void main(String[] args) {
        String[] testData  = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        VerifyAlienDictionary solution = new VerifyAlienDictionary();
        boolean result = solution.isAlienSorted2(testData, order);

        System.out.printf("testData %s Verify AlienDictionary result is %s \n",
                Arrays.toString(testData),result);
    }




}
