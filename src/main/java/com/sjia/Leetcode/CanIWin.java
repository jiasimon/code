package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    // #464. Can I Win      https://leetcode.com/problems/can-i-win/description/
    /*
    In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.

    What if we change the game so that players cannot re-use integers?

    For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.

    Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise, return false. Assume both players play optimally.

    Input: maxChoosableInteger = 10, desiredTotal = 11      Output: false

    Input: maxChoosableInteger = 10, desiredTotal = 0       Output: true

    Input: maxChoosableInteger = 10, desiredTotal = 1       Output: true

    1 <= maxChoosableInteger <= 20
    0 <= desiredTotal <= 300

     */

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // If the desiredTotal is less than or equal to zero, you can win immediately.
        if (desiredTotal <= 0) {
            return true;
        }

        // If the sum of integers from 1 to maxChoosableInteger is less than desiredTotal,
        // you cannot win because you cannot reach the desiredTotal.
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) {
            return false;
        }

        // Create a memoization map to store intermediate results.
        Map<Integer, Boolean> memo = new HashMap<>();

        // Call the recursive helper function.
        return canWin(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean canWin(int maxChoosableInteger, int desiredTotal, int chosen, Map<Integer, Boolean> memo) {
        if (desiredTotal <= 0) {
            return false; // The opponent already won.
        }

        // Check if this state has been computed before.
        if (memo.containsKey(chosen)) {
            return memo.get(chosen);
        }

        // Iterate through the possible choices.
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << (i - 1); // Bit mask to represent the choice.
            if ((chosen & mask) == 0) {
                // If the current number 'i' has not been chosen yet, try it.
                if (!canWin(maxChoosableInteger, desiredTotal - i, chosen | mask, memo)) {
                    // If the opponent cannot win from this state, you win.
                    memo.put(chosen, true);
                    return true;
                }
            }
        }

        // If no winning move is found, mark this state as losing.
        memo.put(chosen, false);
        return false;
    }

    public static void main(String[] args) {
        CanIWin solution = new CanIWin();
        int maxChoosableInteger = 10;
        int desiredTotal = 11;

        boolean canWin = solution.canIWin(maxChoosableInteger, desiredTotal);
        System.out.println("Can I Win? " + canWin); // Output: false
    }



}
