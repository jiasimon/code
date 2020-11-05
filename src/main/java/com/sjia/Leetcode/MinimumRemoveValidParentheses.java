package com.sjia.Leetcode;

import java.util.Stack;

public class MinimumRemoveValidParentheses {
    // # 1249   https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/ #fb


    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty()) st.pop();
                else sb.setCharAt(i, '*');
            }
        }
        while (!st.empty())
            sb.setCharAt(st.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }



    // solution2
    public String minRemoveToMakeValid2(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i + 1);
            if (sb.charAt(i) == ')') {
                if (!st.empty() && st.peek() >= 0) st.pop();
                else st.add(-(i + 1));
            }
        }
        while (!st.empty())
            sb.deleteCharAt(Math.abs(st.pop()) - 1);
        return sb.toString();
    }


}
