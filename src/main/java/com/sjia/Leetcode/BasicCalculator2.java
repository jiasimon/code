package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculator2 {
    // #227. Basic Calculator II    https://leetcode.com/problems/basic-calculator-ii/  #fb
    /*
    Given a string s which represents an expression, evaluate this expression and return its value.

    The integer division should truncate toward zero.

    You may assume that the given expression is always valid.
    All intermediate results will be in the range of [-231, 231 - 1].

    Note: You are not allowed to use any built-in function such as eval().
     */


    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

       Stack<Integer> stack = new Stack<>();
//        Deque<Integer> stack = new ArrayDeque<>();
        char operator = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() - 1) {
                // Handle the previous operator
                switch (operator) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }

                // Update the operator and reset num for the next operand
                operator = ch;
                num = 0;
            }
        }

        // Calculate the final result by summing up all the elements in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }



    public static void main(String[] args) {
        BasicCalculator2 calculatorII = new BasicCalculator2();

        String expression = "3+2*2+10"; // Output: 7
        System.out.println("Result: " + calculatorII.calculate(expression));

        expression = " 3/2 "; // Output: 1
        System.out.println("Result: " + calculatorII.calculate(expression));

        expression = " 3+5 / 2 "; // Output: 5
        System.out.println("Result: " + calculatorII.calculate(expression));
    }



}
