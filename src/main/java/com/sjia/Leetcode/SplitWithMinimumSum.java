package com.sjia.Leetcode;

import java.util.Arrays;

public class SplitWithMinimumSum {
    // #2578. Split With Minimum Sum        https://leetcode.com/problems/split-with-minimum-sum/description/
    /*
    Given a positive integer num, split it into two non-negative integers num1 and num2 such that:

    The concatenation of num1 and num2 is a permutation of num.
    In other words, the sum of the number of occurrences of each digit in num1 and num2 is equal to the number of occurrences of that digit in num.
    num1 and num2 can contain leading zeros.
    Return the minimum possible sum of num1 and num2.

    It is guaranteed that num does not contain any leading zeros.
    The order of occurrence of the digits in num1 and num2 may differ from the order of occurrence of num.

    Input: num = 4325       Output: 59

    Input: num = 687        Output: 75
    10 <= num <= 10^9
     */

    public int splitNum(int num) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char[] chars = String.valueOf(num).toCharArray();

        Arrays.sort(chars);

        for (int i = 0; i < chars.length; ++i)
            if (i % 2 == 0)
                sb1.append(chars[i]);
            else
                sb2.append(chars[i]);

        return Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
    }


    public static void main(String[] args) {
        SplitWithMinimumSum solution = new SplitWithMinimumSum();
        int num = 4325;

        int minSum = solution.splitNum(num);
        System.out.println("Minimum Sum: " + minSum); // Output: 59
    }

}
