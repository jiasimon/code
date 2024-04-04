package com.sjia.Leetcode;

public class MaximumNestingDepthParentheses {
    // #1614. Maximum Nesting Depth of the Parentheses  https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/?envType=daily-question&envId=2024-04-04

    /*
    For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

    Given a VPS represented as string s, return the nesting depth of s.

    Input: s = "(1+(2*3)+((8)/4))+1"    Output: 3

    Input: s = "(1)+((2))+(((3)))"      Output: 3

    1 <= s.length <= 100
    s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
    It is guaranteed that parentheses expression s is a VPS.
     */

    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        MaximumNestingDepthParentheses solution = new MaximumNestingDepthParentheses();

        String testString1 = "(1+(2*3)+((8)/4))+1";
        String testString2 = "(1)+((2))+(((3)))";

        System.out.println("Test Case 1: " + solution.maxDepth(testString1)); // Output: 3
        System.out.println("Test Case 2: " + solution.maxDepth(testString2)); // Output: 3
    }


}
