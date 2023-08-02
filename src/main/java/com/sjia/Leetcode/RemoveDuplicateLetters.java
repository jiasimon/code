package com.sjia.Leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {
    // #316. Remove Duplicate Letters   https://leetcode.com/problems/remove-duplicate-letters/
    /*
    Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
    the smallest in lexicographical order among all possible results.

    Input: s = "bcabc"      Output: "abc"
    Input: s = "cbacdcbc"   Output: "acdb"
    Input: s = "bcac"       Output: "bca"
     */

    public String removeDuplicateLetters_failed(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] lastOccurrence = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            lastOccurrence[chars[i] - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char c = chars[i];

            while (!stack.isEmpty() && c < stack.peek() && lastOccurrence[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;
            }

            if (!visited[c - 'a']) {
                stack.push(c);
                visited[c - 'a'] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }


        return result.toString();
    }


    public String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            lastOccurrence[chars[i] - 'a'] = i;
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            while (!stack.isEmpty() && c < stack.peek() && lastOccurrence[stack.peek() - 'a'] > i && !visited[c - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }

            if (!visited[c - 'a']) {
                stack.push(c);
                visited[c - 'a'] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }


    public static void main(String[] args) {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        String s = "abacb";
        String result = solution.removeDuplicateLetters(s);
        System.out.println(result); // Output: "abc"

        s = "acabcd";
        result = solution.removeDuplicateLetters(s);
        System.out.println(result);

    }

}
