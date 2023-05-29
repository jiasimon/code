package com.sjia.Leetcode;

import java.util.Arrays;

public class PlusOne {

    // #66. Plus One  https://leetcode.com/problems/plus-one/
    /*
    You are given a large integer represented as an integer array digits,
    where each digits[i] is the ith digit of the integer.
    The digits are ordered from most significant to least significant in left-to-right order.
    The large integer does not contain any leading 0's.
     */

    // Input: digits = [1,2,3]  Output: [1,2,4]
    // Input: digits = [9]  Output: [1,0]


    public static int[] plusOne(int[] digits) {
        for (int i= digits.length-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i]=0;
            }
        }
        int[] result = new int[digits.length+1];
        result[0] =1;
        return result;

    }

    public static void main(String[] Args) {
        int[] testData = { 4,3,2,1};
        System.out.println( "test data is: " + Arrays.toString(testData));
        PlusOne solution = new PlusOne();
        int[] result = solution.plusOne(testData);
        System.out.printf(" After plus One is %s \n",  Arrays.toString(result) );

        int[] digits3 = {9,8};
        int[] result3 = plusOne(digits3);
        System.out.println("Plus One Result: " + Arrays.toString(result3)); // Output: [1, 0]

        int[] digits4 = {9,0,9,9};
        int[] result4 = plusOne(digits4);
        System.out.println("Plus One Result: " + Arrays.toString(result4)); // Output: [1, 0]

    }

}
