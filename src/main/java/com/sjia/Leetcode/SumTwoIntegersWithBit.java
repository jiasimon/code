package com.sjia.Leetcode;

public class SumTwoIntegersWithBit {
    // #371. Sum of Two Integers    https://leetcode.com/problems/sum-of-two-integers/description/
    // #bit

    /*
    Given two integers a and b, return the sum of the two integers without using the operators + and -.

     */

    // ^ is XOR to get the carry
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }


    public int getSum_plusEqual(int a, int b) {
        int res =0;

        res += a;
        res += b;
        return res;

    }

    public static void main(String[] args) {
        SumTwoIntegersWithBit solution = new SumTwoIntegersWithBit();
        int a = 5, b = 7;
        int sum = solution.getSum(a, b);
        System.out.println("Sum of " + a + " and " + b + " is: " + sum); // Output: 12
    }

}
