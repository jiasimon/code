package com.sjia.Leetcode;

public class IntegerToRoman {

    // https://leetcode.com/problems/integer-to-roman/
    //Symbol       Value
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    //V             5000

    // Runtime: 21 ms, faster than 8.22% of Java online submissions for Integer to Roman.
    // Memory Usage: 43.9 MB, less than 5.01% of Java online submissions for Integer to Roman.

    static String intToRoman(int num)
    {
        // storing roman values of digits from 0-9 in different position

        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};

        String thousand = m[num/1000];
        String hundered = c[(num%1000)/100];
        String ten = x[(num%100)/10];
        String one = i[num%10];

        String result = thousand + hundered + ten + one;

        return result;
    }


    public static void main(String[] args) {

        //1994  MCMXCIV
        //2020  MMXXX

        int testData  = 2020;
        String result = intToRoman(testData);

        System.out.printf(" %d ToRoman is %s \n", testData, result);

    }

}
