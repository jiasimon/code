package com.sjia.Leetcode;

import java.util.Stack;

public class ValidateParentheses {

    // #20 Valid Parentheses https://leetcode.com/problems/valid-parentheses/submissions/

    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    // add "if (s.isEmpty()) return true;"  for empty string

    static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        if (s.length() <= 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i < s.length(); ++i) {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) return false;
                char p = stack.pop();
                if(s.charAt(i)==')'){
                    if(p != '(') return false;
                } else if (s.charAt(i)==']') {
                    if(p != '[') return false;
                } else if(s.charAt(i)=='}'){
                    if(p != '{') return false;
                }
            }
        }
        return stack.empty();
    }

    // stack
    static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for ( char c: s.toCharArray()) {
            if ( c=='(' || c=='[' || c== '{') {
                stack.push(c);
            } else {
                if ( stack.isEmpty() ) return false;
                if ( c==')' && stack.peek() == '(') stack.pop();
                else if ( c==']' && stack.peek() == '[') stack.pop();
                else if ( c=='}' && stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();

    }


    // Stack store the matching char instead of the actual char
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') // if the character is an opening parenthesis
                stack.push(')'); // push the corresponding closing parenthesis onto the stack
            else if (c == '{') // if the character is an opening brace
                stack.push('}'); // push the corresponding closing brace onto the stack
            else if (c == '[') // if the character is an opening bracket
                stack.push(']'); // push the corresponding closing bracket onto the stack
            else if (stack.isEmpty() || stack.pop() != c) // if the character is a closing bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }



    public static void main(String[] args) {

        //String testData = "([)]"
        //String testData  = "()[]{}";
        String testData  = "()[]{}";
        boolean result = isValid2(testData);

        System.out.printf(" Validate Parentheses is %s \n", result);
    }
}
