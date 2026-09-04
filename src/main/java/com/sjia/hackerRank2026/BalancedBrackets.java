package com.sjia.hackerRank2026;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {
    // https://www.hackerrank.com/challenges/balanced-brackets/problem
    
    public static String isBalanced(String s) {
        // Write your code here
        if (s == null) return "YES";
        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if ( c == '{' || c == '[' || c== '(') {
                stack.push(c);
            } else if ( c == '}' || c == ']' || c== ')') {
                if (stack.isEmpty()) return "NO";
                if (c == '}' && stack.peek() == '{') stack.pop();
                else if (c == ']' && stack.peek() == '[') stack.pop();
                else if (c == ')' && stack.peek() == '(') stack.pop();
                else return "NO";
            }
        }
        if (stack.isEmpty()) return "YES";
        else return "NO";
    }

}
