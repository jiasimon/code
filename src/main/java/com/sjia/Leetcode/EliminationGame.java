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


    // head += step
    // 2 ms, 87.1%; 40.6 MB, 38.52%
    public int lastRemaining(int n) {
        boolean leftToRight = true;
        int remaining = n;
        int head = 1;
        int step =1;


        while( remaining > 1) {
            if (leftToRight || remaining %2 ==1) {
                head = head + step;
            }

            step *= 2;
            remaining /= 2;
            leftToRight = !leftToRight;
        }

        return head;
    }



    // Josephus Problem
    /*
        if you start from the left to right, the result is i
        then, if you start from right to left, the result is n+1-i
        for n numbers, after one pass, there are n/2 left, each number is two times of the original,
        1,2,3,4,5,6,7,8,9
        after one pass
        2,4,6,8
        assume the result of 1,2,3,4 from left to right is f(4)
        then the result of 1,2,3,4 from right to left is 5-f(4)
        then the result of 2,4,6,8 from right to left is 2*(5-f(4))
        this is the formula
        f(n)=2(1+n/2-f(n/2))* when n is 1, of course the result is 1
     */

    public int lastRemaining_math(int n) {
        if ( n==1) return 1;
        return 2* ( n/2 + 1 - lastRemaining_math(n/2) );

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
