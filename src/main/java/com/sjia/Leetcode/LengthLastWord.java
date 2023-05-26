package com.sjia.Leetcode;

import java.util.List;

public class LengthLastWord {

    // #58. Length of Last Word https://leetcode.com/problems/length-of-last-word/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
    //Memory Usage: 39.2 MB, less than 7.46% of Java online submissions for Length of Last Word.
/*
    static int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() -1 - s.lastIndexOf(' ') ;
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
    //Memory Usage: 39.2 MB, less than 7.93% of Java online submissions for Length of Last Word.

    static int lengthOfLastWord(String s) {
        int right = -1, result=0;
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                right = i;
                break;
            }
        }
        if (right == -1) return 0;  // all blank space
        for (int j = right; j>=0; j--) {
            if(s.charAt(j) != ' ') {
                result++;
            } else {
                break;
            }
        }
        return result;

    }

    public int lengthOfLastWord2(String s) {
        s = s.trim();
        if (s.length() == 0 ) return 0;
        int i = s.length() -1, res=0;
        while ( i>=0 ) {
            if (s.charAt(i) ==' ') break;
            else {
                res++;
                i--;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        //String testData  = "Hello World";
        String testData  = "Hello My World  ";
        int result = lengthOfLastWord(testData);

        // String[] eachWord = testData.split(" ");
        // System.out.println( eachWord[eachWord.length - 1].length());

        System.out.printf(" %s : lengthOfLastWord is %s \n",testData, result);
    }



}
