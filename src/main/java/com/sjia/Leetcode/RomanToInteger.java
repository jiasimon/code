package com.sjia.Leetcode;

public class RomanToInteger {
    //  #13 Roman to Integer https://leetcode.com/problems/roman-to-integer/

    //Runtime: 3 ms, faster than 100.00% of Java online submissions for Roman to Integer.
    //Memory Usage: 39.9 MB, less than 56.64% of Java online submissions for Roman to Integer.

    //         int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    //        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

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
        return 0;
    }

/*    static int romanToInt(String s) {
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
    }*/


    // Runtime: 3 ms, faster than 99.96% of Java online submissions for Roman to Integer.
    //Memory Usage: 39 MB, less than 8.76% of Java online submissions for Roman to Integer.
    static int romanToInt(String s) {
        int sum=0, pre = convertToValue(s.charAt(0));
        for (int i=1; i < s.length(); i++) {
            int n = convertToValue(s.charAt(i));
            if (pre < n) sum -= pre;
            else sum += pre;
            pre = n;
        }
        sum += pre;
        return sum;
    }

    public static int romanToInt2(String s) {

        int result =0 , pre = convertToValue(s.charAt(0));
        for ( int i =1; i < s.length(); i++) {
            int tmp = convertToValue(s.charAt(i));
            if (pre < tmp ) result -= pre;
            else result += pre;
            pre = tmp;
        }
        result = result + pre;
        return result;
    }


    public static void main(String[] args) {

        //1994  MCMXCIV
        //2020  MMXXX
        // XIV
        // LVIII
        // III

        String testData = "LVIII";
        int result = romanToInt2(testData);

        System.out.printf(" %s ToRoman is %d \n", testData, result);

    }

}