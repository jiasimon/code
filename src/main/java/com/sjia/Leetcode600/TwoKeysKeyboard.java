package com.sjia.Leetcode600;

public class TwoKeysKeyboard {
    // #650. 2 Keys Keyboard    https://leetcode.com/problems/2-keys-keyboard/description/
    /*
    There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:

    Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
    Paste: You can paste the characters which are copied last time.
    Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

    Input: n = 3    Output: 3
     */

    // dp, dp[i] = dp[j] + (i / j);
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j);
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TwoKeysKeyboard solution = new TwoKeysKeyboard();


        int n = 6;
        System.out.println("Test Case 1: " + solution.minSteps(n)); // Output: 5
    }

}
