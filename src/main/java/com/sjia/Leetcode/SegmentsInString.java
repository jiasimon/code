package com.sjia.Leetcode;

import java.util.Arrays;

public class SegmentsInString {

    // #434. Number of Segments in a String https://leetcode.com/problems/number-of-segments-in-a-string/

    /*
    Given a string s, return the number of segments in the string.

    A segment is defined to be a contiguous sequence of non-space characters.

    Input: s = "Hello, my name is John"     Output: 5
    Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]

    Input: s = "Hello"      Output: 1


     */


    public int countSegments_split(String s) {
        s = s.trim();
        if ( s.length() == 0 ) return 0;

        return s.split("\\s+").length;

    }


    // without split
    // i==0 || s.charAt(i-1) ==' '
    public int countSegments(String s) {
        int res =0;
        for ( int i=0; i < s.length(); i++) {
            if ( ( i==0 || s.charAt(i-1) ==' ') && s.charAt(i) != ' ' ) {
                res++;
            }

        }
        return res;

    }

    public static void main(String[] args) {

        //String testData = "abacd"; dcaba
        String testData  = " ab ba cd";
        SegmentsInString solution = new SegmentsInString();
        int result = solution.countSegments(testData);

        System.out.printf(" input %s , SegmentsInString is %s",testData, result);
    }
}
