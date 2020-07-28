package com.sjia.Leetcode;

public class ExcelSheetColumnNumber {

    // #171 https://leetcode.com/problems/excel-sheet-column-number

    // "AB":28   "ZY" 701   "A":1

    // Runtime: 2 ms, faster than 42.87% of Java online submissions for Excel Sheet Column Number.
    //Memory Usage: 39.6 MB, less than 5.10% of Java online submissions for Excel Sheet Column Number.

    // second run, Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
    //Memory Usage: 38.6 MB, less than 11.57% of Java online submissions for Excel Sheet Column Number.

    static int titleToNumber(String s) {
        int result =0;
        //s.toUpperCase();
        for (int i=0; i< s.length(); i++ ) {
            result += Math.pow(26,i) * ( (int)(  s.charAt(s.length()-1-i) -64 ));
        }
        return result;
    }

    // s.charAt(s.length()-1-i) -'A' +1

/*
    public int titleToNumber(String s) {
        int result = 0;
        for(int i=0;i<s.length() ;i++) {
            int num = s.charAt(i) - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }*/


    // Stream run slower
    // Runtime: 8 ms, faster than 6.26% of Java online submissions for Excel Sheet Column Number.
    //Memory Usage: 39.9 MB, less than 5.10% of Java online submissions for Excel Sheet Column Number.
/*    public int titleToNumber(String s) {
        return s.chars().reduce(0, (r, ch) -> r * 26 + (ch - 'A' + 1));
    }*/



    public static void main(String[] args) {
        String testData = "AAA";
        int result = titleToNumber(testData);
        System.out.printf("Excel Sheet Column %s Number %s", testData, result);

    }

}
