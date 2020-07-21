package com.sjia.Leetcode;

import java.util.Arrays;

public class PlusOneNo66 {

    // #66 https://leetcode.com/problems/plus-one/

    public int[] plusOne(int[] digits) {
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
        //int[] testData = {9,0,9,9};
        int[] testData = { 4,3,2,1};
        System.out.println( "test data is: " + Arrays.toString(testData));
        PlusOneNo66 solution = new PlusOneNo66();
        int[] result = solution.plusOne(testData);
        System.out.printf(" After plus One is %s \n",  Arrays.toString(result) );

    }

}
