package com.sjia.Leetcode;

import java.util.Stack;

public class ValidateParentheses {

    // #20 https://leetcode.com/problems/valid-parentheses/submissions/
    // Runtime: 1 ms, faster than 98.98% of Java online submissions for Valid Parentheses.
    //Memory Usage: 37.4 MB, less than 75.78% of Java online submissions for Valid Parentheses.

    // add "if (s.isEmpty()) return true;"  for empty string

    static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        if (s.length() <= 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i < s.length(); ++i) {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) return false;
                char p = stack.pop();
                if(s.charAt(i)==')'){
                    if(p != '(') return false;
                } else if (s.charAt(i)==']') {
                    if(p != '[') return false;
                } else if(s.charAt(i)=='}'){
                    if(p != '{') return false;
                }
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {

        //String testData = "([)]"
        //String testData  = "()[]{}";
        String testData  = "";
        boolean result = isValid(testData);

        System.out.printf(" Validate Parentheses is %s \n", result);
    }
}
