package com.sjia.Leetcode;

public class ReverseWords3 {
    // #557 https://leetcode.com/problems/reverse-words-in-a-string-iii/

    // Runtime: 4 ms, faster than 86.90% of Java online submissions for Reverse Words in a String III.
    //Memory Usage: 40.4 MB, less than 51.91% of Java online submissions for Reverse Words in a String III.
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word: words) {
            sb.append( new StringBuilder(word).reverse().toString()+" ");
        }
        return sb.toString().trim();
    }


}
