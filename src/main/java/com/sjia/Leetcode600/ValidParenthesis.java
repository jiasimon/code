package com.sjia.Leetcode600;

public class ValidParenthesis {
    // #678. Valid Parenthesis String   https://leetcode.com/problems/valid-parenthesis-string/description/
    /*
    Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

    The following rules define a valid string:
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

    Input: s = "()"     Output: true
    Input: s = "(*)"    Output: true
    Input: s = "(*))"   Output: true

    1 <= s.length <= 100
    s[i] is '(', ')' or '*'.
     */

    // minOpen, maxOpen
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum number of open parentheses needed
        int maxOpen = 0; // Maximum number of open parentheses possible

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                if (minOpen > 0) {
                    minOpen--;
                }
                maxOpen--;
            } else { // c == '*'
                if (minOpen > 0) {
                    minOpen--; // Treat '*' as ')'
                }
                maxOpen++; // Treat '*' as '('
            }

            if (maxOpen < 0) {
                return false; // More closing parentheses than opening ones
            }
        }

        return minOpen == 0; // All open parentheses are closed
    }


    public static void main(String[] args) {
        ValidParenthesis solution = new ValidParenthesis();

        // Test case 1
        String s1 = "(*))";
        System.out.println("Test case 1: " + solution.checkValidString(s1)); // Expected output: true

        // Test case 2
        String s2 = "(*()";
        System.out.println("Test case 2: " + solution.checkValidString(s2)); // Expected output: true

        // Test case 3
        String s3 = "(*)))";
        System.out.println("Test case 3: " + solution.checkValidString(s3)); // Expected output: false

        // Test case 4
        String s4 = "((*)";
        System.out.println("Test case 4: " + solution.checkValidString(s4)); // Expected output: true

        // Test case 5
        String s5 = "(*)";
        System.out.println("Test case 5: " + solution.checkValidString(s5)); // Expected output: true
    }


}
