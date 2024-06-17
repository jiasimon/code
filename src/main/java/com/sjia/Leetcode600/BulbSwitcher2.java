package com.sjia.Leetcode600;

public class BulbSwitcher2 {
    // #672. Bulb Switcher II   https://leetcode.com/problems/bulb-switcher-ii/description/
    /*
    There is a room with n bulbs labeled from 1 to n that all are turned on initially, and four buttons on the wall.
    You must make exactly presses button presses in total. For each press, you may pick any of the four buttons to press.

    Given the two integers n and presses, return the number of different possible statuses after performing all presses button presses.
    Input: n = 1, presses = 1       Output: 2

    Input: n = 3, presses = 1       Output: 4
    1 <= n <= 1000
    0 <= presses <= 1000
     */

    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1; // No change, only one state
        }
        if (n == 1) {
            return 2; // Two states: on or off
        }
        if (n == 2) {
            if (presses == 1) {
                return 3; // Three states: 11, 01, 10
            } else {
                return 4; // Four states: 11, 01, 10, 00
            }
        }
        if (presses == 1) {
            return 4; // Four states: 111, 000, 101, 010
        }
        if (presses == 2) {
            return 7; // Seven states (as derived from combinations of the operations)
        }
        return 8; // All combinations of three presses will cover all 8 possible states
    }

    public static void main(String[] args) {
        BulbSwitcher2 solution = new BulbSwitcher2();

        // Test case 1
        int n1 = 1, presses1 = 1;
        System.out.println("Test case 1: " + solution.flipLights(n1, presses1)); // Expected output: 2

        // Test case 2
        int n2 = 2, presses2 = 1;
        System.out.println("Test case 2: " + solution.flipLights(n2, presses2)); // Expected output: 3

        // Test case 3
        int n3 = 3, presses3 = 1;
        System.out.println("Test case 3: " + solution.flipLights(n3, presses3)); // Expected output: 4

        // Test case 4
        int n4 = 3, presses4 = 2;
        System.out.println("Test case 4: " + solution.flipLights(n4, presses4)); // Expected output: 7

        // Test case 5
        int n5 = 3, presses5 = 3;
        System.out.println("Test case 5: " + solution.flipLights(n5, presses5)); // Expected output: 8

        // Test case 6
        int n6 = 2, presses6 = 2;
        System.out.println("Test case 6: " + solution.flipLights(n6, presses6)); // Expected output: 4

        // Test case 7
        int n7 = 1, presses7 = 0;
        System.out.println("Test case 7: " + solution.flipLights(n7, presses7)); // Expected output: 1
    }

    

}
