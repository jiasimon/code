package com.sjia.Leetcode600;

import java.util.ArrayList;
import java.util.List;

public class Game24 {
    // #679. 24 Game    https://leetcode.com/problems/24-game/description/
    /*
    the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.

    Input: cards = [4,1,8,7]    Explanation: (8-4) * (7-1) = 24
     */

    private static final double EPSILON = 1e-6;
    private static final int TARGET = 24;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return helper(nums);
    }

    private boolean helper(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    List<Double> nextRound = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            nextRound.add(nums.get(k));
                        }
                    }
                    for (double num : compute(nums.get(i), nums.get(j))) {
                        nextRound.add(num);
                        if (helper(nextRound)) {
                            return true;
                        }
                        nextRound.remove(nextRound.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > EPSILON) {
            results.add(a / b);
        }
        if (Math.abs(a) > EPSILON) {
            results.add(b / a);
        }
        return results;
    }


    public static void main(String[] args) {
        Game24 solution = new Game24();

        // Test case 1
        int[] cards1 = {4, 1, 8, 7};
        System.out.println("Test case 1: " + solution.judgePoint24(cards1)); // Expected output: true

        // Test case 2
        int[] cards2 = {1, 2, 1, 2};
        System.out.println("Test case 2: " + solution.judgePoint24(cards2)); // Expected output: false

        // Test case 3
        int[] cards3 = {3, 3, 8, 8};
        System.out.println("Test case 3: " + solution.judgePoint24(cards3)); // Expected output: true

        // Test case 4
        int[] cards4 = {1, 3, 4, 6};
        System.out.println("Test case 4: " + solution.judgePoint24(cards4)); // Expected output: true

        // Test case 5
        int[] cards5 = {5, 5, 5, 1};
        System.out.println("Test case 5: " + solution.judgePoint24(cards5)); // Expected output: true
    }



}
