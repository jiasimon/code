package com.sjia.Leetcode700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLispExpression {
    // #736. Parse Lisp Expression  https://leetcode.com/problems/parse-lisp-expression/description/
    /*
Problem Summary:

Implement an interpreter for a simplified version of Lisp. The expression can contain:

    add: Sum two values.
    mult: Multiply two values.
    let: Assign values to variables and evaluate expressions.

Recursive Parsing:

    The expression follows a recursive structure with nested sub-expressions.
    Use a helper function to evaluate each part.

Variable Scope:

    Use a stack-based approach to track variable assignments.
    Each let expression can introduce new variable scopes.

Parsing Strategy:

    Handle the expression based on its prefix (add, mult, let).
    Parse tokens carefully by tracking parentheses.

    Note: chatgpt failed on this

     */

    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<>());
    }

    private int evaluate(final String e, Map<String, Integer> prevScope) {
        if (Character.isDigit(e.charAt(0)) || e.charAt(0) == '-')
            return Integer.parseInt(e);
        if (prevScope.containsKey(e))
            return prevScope.get(e);

        Map<String, Integer> scope = new HashMap<>();
        scope.putAll(prevScope);

        final int spaceIndex = e.indexOf(' ');
        // +1 and -1 because of "()".
        final String nextExpression = e.substring(spaceIndex + 1, e.length() - 1);
        List<String> tokens = split(nextExpression);

        if (e.startsWith("(m")) // 'mult'
            return evaluate(tokens.get(0), scope) * evaluate(tokens.get(1), scope);
        if (e.startsWith("(a")) // 'add'
            return evaluate(tokens.get(0), scope) + evaluate(tokens.get(1), scope);

        // 'let'
        for (int i = 0; i < tokens.size() - 2; i += 2)
            scope.put(tokens.get(i), evaluate(tokens.get(i + 1), scope));
        return evaluate(tokens.get(tokens.size() - 1), scope);
    }

    private List<String> split(final String s) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int opened = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                ++opened;
            else if (c == ')')
                --opened;
            if (opened == 0 && c == ' ') {
                tokens.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0)
            tokens.add(sb.toString());
        return tokens;
    }

    public static void main(String[] args) {
        ParseLispExpression solution = new ParseLispExpression();

        // Test Case 1
        System.out.println(solution.evaluate("(add 1 2)")); // Expected: 3

        // Test Case 2
        System.out.println(solution.evaluate("(mult 3 (add 2 3))")); // Expected: 15

        // Test Case 3
        System.out.println(solution.evaluate("(let x 2 (mult x 5))")); // Expected: 10

        // Test Case 4
        System.out.println(solution.evaluate("(let x 2 (let x 3 (let x 4 x)))")); // Expected: 4

        // Test Case 5
        System.out.println(solution.evaluate("(let x 1 y 2 x (add x y) (add x y))")); // Expected: 3
    }


}
