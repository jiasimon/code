package com.sjia.Leetcode1000;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseSubstringParentheses {
    // #1190 Reverse substring between Each Pair of Parentheses
    // https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/

    public String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray())
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {
                // Reverse the corresponding substring between ().
                StringBuilder reversed = new StringBuilder();
                for (int sz = sb.length() - stack.pop(); sz > 0; --sz) {
                    reversed.append(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(reversed);
            } else {
                sb.append(c);
            }
        return sb.toString();
    }

}
