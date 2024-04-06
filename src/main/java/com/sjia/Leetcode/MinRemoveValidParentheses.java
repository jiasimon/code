package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinRemoveValidParentheses {
    // #1249. Minimum Remove to Make Valid Parentheses  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/?envType=daily-question&envId=2024-04-06
    /*
    Given a string s of '(' , ')' and lowercase English characters.

    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

    Input: s = "lee(t(c)o)de)"      Output: "lee(t(c)o)de"
    Input: s = "a)b(c)d"            Output: "ab(c)d"
    Input: s = "))(("               Output: ""
     */

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '(') {
                stack.push(i);  // Record the unpaired '(' index
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');  // Mark the unpaired ')' as *
                }
            }
        }

        // Mark the unpaired '(' as '*'.
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        return sb.toString().replaceAll("\\*", "");
    }


    public static void main(String[] args) {
        MinRemoveValidParentheses solution = new MinRemoveValidParentheses();

//        String testString1 = "lee(t(c)o)de)";
//        String testString2 = "a)b(c)d";
        String testString3 = "))((";

//        System.out.println("Test Case 1: " + solution.minRemoveToMakeValid(testString1)); // Output: "lee(t(c)o)de"
//        System.out.println("Test Case 2: " + solution.minRemoveToMakeValid(testString2)); // Output: "ab(c)d"
        System.out.println("Test Case 3: " + solution.minRemoveToMakeValid(testString3)); // Output: ""
    }

}
