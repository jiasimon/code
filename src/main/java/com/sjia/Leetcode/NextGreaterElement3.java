package com.sjia.Leetcode;

public class NextGreaterElement3 {
    // #556. Next Greater Element III   https://leetcode.com/problems/next-greater-element-iii/description/

    /*
    Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

    Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

    Input: n = 12   Output: 21
    Input: n = 21   Output: -1

    1 <= n <= 2^31 - 1
     */

    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i == -1) return -1; // If the digits are in descending order, there's no next greater element

        int j = digits.length - 1;
        while (j >= 0 && digits[j] <= digits[i]) {
            j--;
        }

        swap(digits, i, j);
        reverse(digits, i + 1);

        long next = Long.parseLong(new String(digits));
        if (next > Integer.MAX_VALUE) return -1; // Check if the next number exceeds the integer limit

        return (int) next;
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private void reverse(char[] digits, int start) {
        int end = digits.length - 1;
        while (start < end) {
            swap(digits, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextGreaterElement3 solution = new NextGreaterElement3();

        int testNumber = 123;
        System.out.println("Test Case 1: " + solution.nextGreaterElement(testNumber)); // Output: 132
    }

}
