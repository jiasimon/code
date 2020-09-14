package com.sjia.Leetcode;

import java.util.Stack;

public class BackspaceString {
    // #844 https://leetcode.com/problems/backspace-string-compare/
    // Given two strings S and T, return if they are equal when both are typed into empty text editors.
    // # means a backspace character.

    // Input: S = "ab##", T = "c#d#"
    // S = "a##c", T = "#a#c"

    // Runtime: 2 ms, faster than 46.31% of Java online submissions for Backspace String Compare.
    //Memory Usage: 38.3 MB, less than 32.68% of Java online submissions for Backspace String Compare.
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));

    }

    private String helper(String s) {
        Stack<Character> res = new Stack<>();
        for( char c: s.toCharArray()) {
            if(c!='#') res.push(c);
            else if (! res.isEmpty()) {
                res.pop();
            }
        }
        return String.valueOf(res);
    }


    public static void main(String[] args) {
        String  testData  = "a##c";  // "ab#c"
        String  testData2 = "#a#c"; // "ad#c"
        BackspaceString solution = new BackspaceString();
        boolean result = solution.backspaceCompare(testData, testData2);

        System.out.printf("testData: %s, testData2: %s backspaceCompare is %s \n",
                testData,testData2, result);
    }


}
