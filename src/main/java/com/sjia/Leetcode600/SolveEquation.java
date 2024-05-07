package com.sjia.Leetcode600;

public class SolveEquation {
    // #640. Solve the Equation https://leetcode.com/problems/solve-the-equation/description/
    /*
    If there is exactly one solution for the equation, we ensure that the value of 'x' is an integer.

    Input: equation = "x+5-3+x=6+x-2"   Output: "x=2"
    Input: equation = "x=x"         Output: "Infinite solutions"
    Input: equation = "2x=x"        Output: "x=0"

    3 <= equation.length <= 1000
    equation has exactly one '='.
     */

    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);

        int coef = left[0] - right[0];
        int num = right[1] - left[1];

        if (coef == 0) {
            return num == 0 ? "Infinite solutions" : "No solution";
        }

        return "x=" + num / coef;
    }

    private int[] evaluate(String expr) {
        int coef = 0, num = 0, sign = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == 'x') {
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) == '-') {
                    sb.append('1');
                }
                coef += sign * Integer.parseInt(sb.toString());
                sb.setLength(0);
            } else {
                if (sb.length() > 0) {
                    num += sign * Integer.parseInt(sb.toString());
                }
                sb.setLength(0);
                sign = (c == '+' ? 1 : -1);
            }
        }

        if (sb.length() > 0) {
            num += sign * Integer.parseInt(sb.toString());
        }

        return new int[]{coef, num};
    }

    public static void main(String[] args) {
        SolveEquation solution = new SolveEquation();

        // Test Case
        String equation = "2x+3x-6x=x+2";
        System.out.println("Test Case 1: " + solution.solveEquation(equation)); // Output: "x=2"
    }


}
