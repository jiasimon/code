package com.sjia.Leetcode;

import java.util.Arrays;

public class AddDigits {

    // #258. Add Digits https://leetcode.com/problems/add-digits/



    // Math pattern
    public int addDigits2(int num) {
        if( num ==0) return 0;
        if ( num %9 == 0) return 9;
        return num % 9;
    }


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Digits.
    //Memory Usage: 36.2 MB, less than 94.62% of Java online submissions for Add Digits.
    public int addDigits(int num) {
        while ( num >= 10) {
            num = num/10 + num %10;
        }
        return num;
    }


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Digits.
    //Memory Usage: 38.6 MB, less than 5.39% of Java online submissions for Add Digits.
/*
    public int addDigits(int num) {
        while (num > 9) {
            int tmp = 0;
            while ( num>0) {
                tmp += num%10;
                num /=10;
            }
            num = tmp;
        }
        return num;
    }*/


    // O(1) took longer time ??
    // Runtime: 3 ms, faster than 12.36% of Java online submissions for Add Digits.
    //Memory Usage: 38.7 MB, less than 5.39% of Java online submissions for Add Digits.

/*
    public int addDigits(int num) {
        return (num-1) % 9 +1;
    }*/


    public static void main(String[] args) {
        int testData  = 38;  // 182
        AddDigits solution = new AddDigits();
        int result = solution.addDigits(testData);

        System.out.printf("testData %s add digits is %s \n", testData,result);
    }


}
