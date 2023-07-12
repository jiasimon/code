package com.sjia.Leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    // #150. Evaluate Reverse Polish Notation   https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
    /*
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

    Evaluate the expression. Return an integer that represents the value of the expression.

    The valid operators are '+', '-', '*', and '/'.

    The division between two integers always truncates toward zero.
     */

    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if(s.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a-b);
            } else if (s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a/b);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }



}
