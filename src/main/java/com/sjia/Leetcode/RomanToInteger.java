package com.sjia.Leetcode;

public class RomanToInteger {
    // https://leetcode.com/problems/roman-to-integer/

    //Runtime: 3 ms, faster than 100.00% of Java online submissions for Roman to Integer.
    //Memory Usage: 39.9 MB, less than 56.64% of Java online submissions for Roman to Integer.

    static int convertToValue(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    static int romanToInt(String s) {
        int total = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            int s1 = convertToValue(s.charAt(i));
            if (i + 1 < len) {
                int s2 = convertToValue(s.charAt(i + 1));
                total = ((s1 >= s2) ? total + s1 : total - s1);
            } else {
                total += s1;
            }
        }
        return total;
    }


    public static void main(String[] args) {

        //1994  MCMXCIV
        //2020  MMXXX

        String testData = "MCMXCIV";
        int result = romanToInt(testData);

        System.out.printf(" %s ToRoman is %d \n", testData, result);

    }

}