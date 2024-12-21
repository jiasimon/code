package com.sjia.Leetcode700;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NumberAtoms {
    // #726. Number of Atoms    https://leetcode.com/problems/number-of-atoms/description/
    /*
    Recursive Parsing:
        Use a stack to manage nested groups of atoms in parentheses.
        Parse numbers, atom names, and parentheses properly.

    Merge Counts:
        Combine counts when encountering closing parentheses.

    Sort and Build Result:
        Sort atom counts by name and format them as a string.
     */

    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());

        int n = formula.length();
        for (int i = 0; i < n; ) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;

                Map<String, Integer> top = stack.pop();
                Map<String, Integer> current = stack.peek();
                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    current.put(entry.getKey(), current.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiplier);
                }
            } else {
                int start = i;
                i++; // Move past the first character of the atom
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String atom = formula.substring(start, i);

                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;

                Map<String, Integer> current = stack.peek();
                current.put(atom, current.getOrDefault(atom, 0) + count);
            }
        }

        Map<String, Integer> result = stack.pop();
        StringBuilder sb = new StringBuilder();
        result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    sb.append(entry.getKey());
                    if (entry.getValue() > 1) {
                        sb.append(entry.getValue());
                    }
                });

        return sb.toString();
    }

    public static void main(String[] args) {
        NumberAtoms solution = new NumberAtoms();

        // Test Case 1
        String formula1 = "H2O";
        System.out.println(solution.countOfAtoms(formula1)); // Output: "H2O"

        // Test Case 2
        String formula2 = "Mg(OH)2";
        System.out.println(solution.countOfAtoms(formula2)); // Output: "H2MgO2"

        // Test Case 3
        String formula3 = "K4(ON(SO3)2)2";
        System.out.println(solution.countOfAtoms(formula3)); // Output: "K4N2O14S4"

        // Test Case 4
        String formula4 = "Be32";
        System.out.println(solution.countOfAtoms(formula4)); // Output: "Be32"
    }


}
