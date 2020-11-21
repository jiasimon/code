package com.sjia.Leetcode;

import java.util.Stack;

public class MinimumRemoveValidParentheses {
    // # 1249   https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/ #fb
    // Input: s = "lee(t(c)o)de)"   Output: "lee(t(c)o)de"
    // Input: s = "a)b(c)d"     Output: "ab(c)d"
    // Input: s = "))(("        Output: ""
    // Input: s = "(a(b(c)d)"   Output: "a(b(c)d)"


    // 1 <= s.length <= 10^5
    // s[i] is one of  '(' , ')' and lowercase English letters.


    // use special char to mark Parentheses to remove
    // Runtime: 20 ms, faster than 34.78% of Java online submissions for Minimum Remove to Make Valid Parentheses.
    //Memory Usage: 39.8 MB, less than 58.43% of Java online submissions for Minimum Remove to Make Valid Parentheses.

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty()) st.pop();
                else sb.setCharAt(i, '*');
            }
        }
        while (!st.empty())
            sb.setCharAt(st.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }




    // solution2
    public String minRemoveToMakeValid2(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i + 1);
            if (sb.charAt(i) == ')') {
                if (!st.empty() && st.peek() >= 0) st.pop();
                else st.add(-(i + 1));
            }
        }
        while (!st.empty())
            sb.deleteCharAt(Math.abs(st.pop()) - 1);
        return sb.toString();
    }


    // String[] arr = s.split("")   slow performance
    // 102 ms	50.9 MB
    public String minRemoveToMakeValid3(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if ("(".equals(arr[i])) {
                stack.push(i);
            } else if (")".equals(arr[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = "";
                }
            }
        }
        while(!stack.isEmpty()) {
            arr[stack.pop()] = "";
        }
        return String.join("", arr);
    }


    public static void main(String[] args) {
        // String testData  = "))((";
        String testData  = "lee(t(c)o)de)";
        MinimumRemoveValidParentheses solution = new MinimumRemoveValidParentheses();
        String result = solution.minRemoveToMakeValid(testData);

        System.out.printf("testData %s MinimumRemove to get ValidParentheses is %s \n", testData,result);
    }

}
