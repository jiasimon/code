package com.sjia.Leetcode;

public class EliminationGame {
    // #390. Elimination Game   https://leetcode.com/problems/elimination-game/description/

    /*
    You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:

    Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
    Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
    Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
    Given the integer n, return the last number that remains in arr.

    Input: n = 9    Output: 6
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    arr = [2, 4, 6, 8]
    arr = [2, 6]
    arr = [6]
     */

    public int lastRemaining(int n) {
        boolean leftToRight = true; // Direction of elimination
        int remaining = n;
        int step = 1;
        int head = 1;

        while (remaining > 1) {
            if (leftToRight || remaining % 2 == 1) {
                head += step;
            }
            step *= 2;
            remaining /= 2;
            leftToRight = !leftToRight;
        }

        return head;
    }


    public static void main(String[] args) {
        EliminationGame solution = new EliminationGame();
        int n = 9;
        int lastRemaining = solution.lastRemaining(n);
        System.out.println("Last remaining integer: " + lastRemaining); // Output: 6

        n = 16;
        lastRemaining = solution.lastRemaining(n);
        System.out.println("Last remaining integer: " + lastRemaining); // Output: 6

        n = 18;
        lastRemaining = solution.lastRemaining(n);
        System.out.println("Last remaining integer: " + lastRemaining); // Output: 8

        n = 20;
        lastRemaining = solution.lastRemaining(n);
        System.out.println("Last remaining integer: " + lastRemaining); // Output: 8

    }


}
