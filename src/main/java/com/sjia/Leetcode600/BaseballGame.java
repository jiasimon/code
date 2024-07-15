package com.sjia.Leetcode600;

import java.util.Stack;

public class BaseballGame {
    // #682. Baseball Game      https://leetcode.com/problems/baseball-game/description/
    /*
    You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
    You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
    Input: ops = ["5","2","C","D","+"]  Output: 30
    Input: ops = ["5","-2","4","C","D","9","+","+"] Output: 27
     */

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }

        return sum;
    }

    public static void main(String[] args) {
        BaseballGame solution = new BaseballGame();

        // Test case 1
        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println("Test case 1: " + solution.calPoints(ops1)); // Expected output: 30

        // Test case 2
        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("Test case 2: " + solution.calPoints(ops2)); // Expected output: 27

        // Test case 3
        String[] ops3 = {"1", "C"};
        System.out.println("Test case 3: " + solution.calPoints(ops3)); // Expected output: 0

        // Test case 4
//        String[] ops4 = {"5", "6", "C", "+", "D"};
//        System.out.println("Test case 4: " + solution.calPoints(ops4)); // Expected output: 11

        // Test case 5
        String[] ops5 = {"10", "20", "+", "C", "D", "-10", "+"};
        System.out.println("Test case 5: " + solution.calPoints(ops5)); // Expected output: 90
    }


}
