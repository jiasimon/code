package com.sjia.Leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    //#32 https://leetcode.com/problems/longest-valid-parentheses/

    // Runtime: 3 ms, faster than 43.96% of Java online submissions for Longest Valid Parentheses.
    //Memory Usage: 40.3 MB, less than 12.75% of Java online submissions for Longest Valid Parentheses.

    // did not change any code, second run with below info
    // Runtime: 2 ms, faster than 75.83% of Java online submissions for Longest Valid Parentheses.
    //Memory Usage: 38.3 MB, less than 89.24% of Java online submissions for Longest Valid Parentheses.

/*
    static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }*/


    // Stack solution
    // Runtime: 7 ms, faster than 16.34% of Java online submissions for Longest Valid Parentheses.
    //Memory Usage: 40.7 MB, less than 7.76% of Java online submissions for Longest Valid Parentheses.

    static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        // int range:  -2147483648～2147483647

        //String testData = "()((())";
        //String testData  = ")()())";
        String testData  = "()((())";
        int result = longestValidParentheses(testData);

        System.out.printf(" input %s longest Valid Parentheses is: %s ", testData, result);
    }

}
