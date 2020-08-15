package com.sjia.Leetcode;

import java.util.Arrays;

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


    //Runtime: 5 ms, faster than 75.32% of Java online submissions for Reverse Words in a String III.
    //Memory Usage: 40.1 MB, less than 69.95% of Java online submissions for Reverse Words in a String III.


    // Java8 Stream
/*
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).map(str -> new StringBuffer(str).reverse().toString())
        .collect(Collectors.joining(" "));
    }*/


}
