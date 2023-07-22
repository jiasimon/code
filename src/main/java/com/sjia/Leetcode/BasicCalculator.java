package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculator {
    // #224. Basic Calculator   https://leetcode.com/problems/basic-calculator/description/
    /*
    Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

    Input: s = "1 + 1"  Output: 2
    Input: s = "(1+(4+5+2)-3)+(6+8)"    Output: 23
     */

    // Deque, ArrayDeque
    public int calculate(String s) {
        int ans = 0;
        int num = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>(); // Stack.peek(): current env's sign
        stack.push(sign);

        for (final char c : s.toCharArray())
            if (Character.isDigit(c))
                num = num * 10 + (c - '0');
            else if (c == '(')
                stack.push(sign);
            else if (c == ')')
                stack.pop();
            else if (c == '+' || c == '-') {
                ans += sign * num;
                sign = (c == '+' ? 1 : -1) * stack.peek();
                num = 0;
            }

        return ans + sign * num;

    }



    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // If the character is a digit, parse the entire number and update the result accordingly
                int num = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += sign * num;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                // Push the current result and sign to the stack
                stack.push(result);
                stack.push(sign);

                // Reset result and sign for evaluating the expression inside the parentheses
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                // Evaluate the expression inside the parentheses
                // Pop the sign first
                result *= stack.pop();

                // Pop the previous result and add it to the current result
                result += stack.pop();
            }
        }

        return result;
    }




    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        String expression = "1 + 1"; // Output: 2
        System.out.println("Result: " + calculator.calculate(expression));

        expression = " 2-1 + 2 "; // Output: 3
        System.out.println("Result: " + calculator.calculate(expression));

        expression = "(1+(4+5+2)-3)+(6+8)"; // Output: 23
        System.out.println("Result: " + calculator.calculate(expression));
    }

}
