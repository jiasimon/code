package com.sjia.Leetcode600;

public class MaximumSwap {
    // #670. Maximum Swap   https://leetcode.com/problems/maximum-swap/description/
    /*
    #interview
    You are given an integer num. You can swap two digits at most once to get the maximum valued number.

    Return the maximum valued number you can get.
    Input: num = 2736       Output: 7236

    Input: num = 9973       Output: 9973

    0 <= num <= 10^8
     */


    // last[digits[i] - '0'] = i
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        int[] last = new int[10];

        // Record the last position of each digit 0-9 in the number
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;
        }

        // Try to find the first digit that can be swapped to get a larger number
        for (int i = 0; i < n; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap digits[i] with digits[last[d]]
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        MaximumSwap solution = new MaximumSwap();

        // Test case 1
        int num1 = 2736;
        System.out.println("Test case 1: " + solution.maximumSwap(num1));  // Expected output: 7236

        // Test case 2
        int num2 = 9973;
        System.out.println("Test case 2: " + solution.maximumSwap(num2));  // Expected output: 9973

        // Test case 3
        int num3 = 1234;
        System.out.println("Test case 3: " + solution.maximumSwap(num3));  // Expected output: 4231

        // Test case 4
        int num4 = 98368;
        System.out.println("Test case 4: " + solution.maximumSwap(num4));  // Expected output: 98863

        // Test case 5
        int num5 = 1993;
        System.out.println("Test case 5: " + solution.maximumSwap(num5));  // Expected output: 9913
    }


}
