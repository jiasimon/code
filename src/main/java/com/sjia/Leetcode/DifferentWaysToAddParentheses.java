package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    // #241. Different Ways to Add Parentheses  https://leetcode.com/problems/different-ways-to-add-parentheses/description/
    /*
    Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

    The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

    Input: expression = "2-1-1"     Output: [0,2]
    ((2-1)-1) = 0   (2-(1-1)) = 2
    Input: expression = "2*3-4*5"   Output: [-34,-14,-10,-10,10]
    (2*(3-(4*5))) = -34     ((2*3)-(4*5)) = -14     ((2*(3-4))*5) = -10
    (2*((3-4)*5)) = -10     (((2*3)-4)*5) = 10

     */


    // divide two parts on operator, recursive, calculate res
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i=0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if ( c== '+' || c == '-' || c =='*') {
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                for (int leftRes: leftResults) {
                    for (int rightRes: rightResults) {
                        int tmp = 0;
                        if (c== '+') {
                            tmp = leftRes + rightRes;
                        } else if (c== '-') {
                            tmp = leftRes - rightRes;
                        } else if (c== '*') {
                            tmp = leftRes * rightRes;
                        }
                        res.add(tmp);
                    }
                }

            }

        }

        // If the expression does not contain any operators, add the value to the result list
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }

        return res;
    }


    public static void main(String[] args) {
        DifferentWaysToAddParentheses solution = new DifferentWaysToAddParentheses();

        String expression = "2-1-1";
        List<Integer> result = solution.diffWaysToCompute(expression);
        // Output: [0, 2]
        System.out.println(result);

        expression = "2*3-4*5";
        result = solution.diffWaysToCompute(expression);
        // Output: [-34, -14, -10, -10, 10]
        System.out.println(result);
    }


}
