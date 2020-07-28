package com.sjia.Leetcode;

public class ExcelSheetColumnNumber {

    // #171 https://leetcode.com/problems/excel-sheet-column-number

    // "AB":28   "ZY" 701   "A":1

    // Runtime: 2 ms, faster than 42.87% of Java online submissions for Excel Sheet Column Number.
    //Memory Usage: 39.6 MB, less than 5.10% of Java online submissions for Excel Sheet Column Number.

    static int titleToNumber(String s) {
        int result =0;
        //s.toUpperCase();
        for (int i=0; i< s.length(); i++ ) {
            result += Math.pow(26,i) * ( (int)(  s.charAt(s.length()-1-i) -64 ));
        }
        return result;
    }

    

    public static void main(String[] args) {
        String testData = "ZY";
        int result = titleToNumber(testData);
        System.out.printf("Excel Sheet Column %s Number %s", testData, result);

    }

}
