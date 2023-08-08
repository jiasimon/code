package com.sjia.Leetcode;

import java.util.*;

public class RemoveInvalidParentheses {
    // #301. Remove Invalid Parentheses     https://leetcode.com/problems/remove-invalid-parentheses/
    /*
    Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

    Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

    Input: s = "()())()"    Output: ["(())()","()()()"]
    Input: s = "(a)())()"   Output: ["(a())()","(a)()()"]
    Input: s = ")("         Output: [""]


     */

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        boolean found = false;
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (isValid(current)) {
                result.add(current);
                found = true;
            }
            if (found) {
                continue;
            }
// Generate all possible next strings by removing a parenthesis
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == '(' || current.charAt(i) == ')') {
                    String next = current.substring(0, i) + current.substring(i + 1);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();
        String s = "()())()";
        List<String> result = solution.removeInvalidParentheses(s);
        System.out.println(result); // Output: ["()()()", "(())()"]
    }



}
