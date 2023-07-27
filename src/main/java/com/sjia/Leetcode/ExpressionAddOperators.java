package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    // #282. Expression Add Operators   https://leetcode.com/problems/expression-add-operators/      #revisit
    /*
    Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

    Note that operands in the returned expressions should not contain leading zeros.
    Input: num = "123", target = 6  Output: ["1*2*3","1+2+3"]
    Input: num = "232", target = 8  Output: ["2*3+2","2+3*2"]
    1*0+5 and 10-5 target = 15

     */

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, target, 0, 0, "", result);
        return result;
    }


    private void backtrack(String num, int target, long eval, long prevNum, String expr, List<String> result) {
        if (num.length() == 0) {
            if (eval == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = 1; i <= num.length(); i++) {
            String currStr = num.substring(0, i);
            if (currStr.length() > 1 && currStr.charAt(0) == '0') {
                return;
            }
            long currNum = Long.parseLong(currStr);

            if (expr.length() == 0) {
                backtrack(num.substring(i), target, currNum, currNum, currStr, result);
            } else {
                backtrack(num.substring(i), target, eval + currNum, currNum, expr + "+" + currStr, result);
                backtrack(num.substring(i), target, eval - currNum, -currNum, expr + "-" + currStr, result);
                backtrack(num.substring(i), target, eval - prevNum + prevNum * currNum, prevNum * currNum, expr + "*" + currStr, result);
            }
        }
    }



    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        ExpressionAddOperators solution = new ExpressionAddOperators();
        List<String> result = solution.addOperators(num, target);
        System.out.println("Possible expressions to get target " + target + ": ");
        for (String expr : result) {
            System.out.println(expr);
        }
        // Output: Possible expressions to get target 6:
        // 1+2+3
        // 1*2*3
    }


}
