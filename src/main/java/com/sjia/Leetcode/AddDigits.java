package com.sjia.Leetcode;

import java.util.Arrays;

public class AddDigits {

    // #258 https://leetcode.com/problems/add-digits/

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Digits.
    //Memory Usage: 36.2 MB, less than 94.62% of Java online submissions for Add Digits.
    public int addDigits(int num) {
        while ( num >= 10) {
            num = num/10 + num %10;
        }
        return num;
    }

    public static void main(String[] args) {


        int testData  = 182;  // 37
        AddDigits solution = new AddDigits();
        int result = solution.addDigits(testData);

        System.out.printf("testData %s add digits is %s \n", testData,result);
    }


}
