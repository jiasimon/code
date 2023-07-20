package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

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

}
