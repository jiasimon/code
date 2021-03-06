package com.sjia.Leetcode;

import java.util.Stack;

public class MakeStringGreat {
    // #1544  https://leetcode.com/problems/make-the-string-great/

    // A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
    // 0 <= i <= s.length - 2
    // s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.

    // Input: s = "leEeetcode"  Output: "leetcode"
    // Input: s = "abBAcC"      Output: ""


    // StringBuilder
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Make The String Great.
    // Memory Usage: 37.9 MB, less than 74.91% of Java online submissions for Make The String Great.
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.length() >0 && Math.abs(sb.charAt(sb.length()-1) - c) == 32) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Make The String Great.
    // Memory Usage: 37.9 MB, less than 71.85% of Java online submissions for Make The String Great.
    public String makeGood2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.length() >0 && ( sb.charAt(sb.length()-1) ^ c) == 32 ) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    // Stack
    // Runtime: 2 ms, faster than 89.31% of Java online submissions for Make The String Great.
    // Memory Usage: 37.6 MB, less than 89.53% of Java online submissions for Make The String Great.
    public String makeGood3(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length(); i++) {
            if (! stack.isEmpty()&& ( stack.peek() ^ s.charAt(i)) == 32 ) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        char res[] = new char[stack.size()];
        int j = stack.size() -1;
        while (j>=0) {
            res[j--] = stack.pop();
        }
        return new String(res);

    }



}
