package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumProductWordLengths {
    // #318. Maximum Product of Word Lengths    https://leetcode.com/problems/maximum-product-of-word-lengths/description/
    /*
    Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.
    Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]   Output: 16
    Explanation: The two words can be "abcw", "xtfn".

    Input: words = ["a","ab","abc","d","cd","bcd","abcd"]   Output: 4
    Explanation: The two words can be "ab", "cd".

    Input: words = ["a","aa","aaa","aaaa"]  Output: 0

     */




    // List<Set<Character>>
    // 216ms, 25.98%; 48.09mb, 6.99%
    public int maxProduct_Hashset(String[] words) {
        int n = words.length;

        int res = 0;
        List<Set<Character>> list = new ArrayList(n);

        for (String word : words) {
            Set<Character> set = new HashSet();
            list.add(set);
            for ( int i=0; i< word.length(); i++) {
                set.add(word.charAt(i));
            }
        }

        for (int i=0; i < n ; i++) {
            Set<Character> setI = list.get(i);
            for (int j = i+1; j < n; j++) {
                boolean hasCommon = false;
                Set<Character> setJ = list.get(j);
                for(Character c : setI) {
                    if( setJ.contains(c) ) {
                        hasCommon = true;
                        break;
                    }
                }
                if( !hasCommon )
                    res = Math.max(res, words[i].length()*words[j].length());
            }
        }
        return res;
    }



    public static void main(String[] args) {
        MaximumProductWordLengths solution = new MaximumProductWordLengths();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int result = solution.maxProduct_Hashset(words);
        System.out.println(result); // Output: 16 (Product of "abcw" and "xtfn")
    }

}
