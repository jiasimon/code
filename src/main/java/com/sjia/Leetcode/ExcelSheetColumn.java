package com.sjia.Leetcode;

import java.util.Arrays;

public class ExcelSheetColumn {

    // #168. Excel Sheet Column Title   https://leetcode.com/problems/excel-sheet-column-title/description/
    // https://leetcode-cn.com/problems/excel-sheet-column-title/

    /*
    A -> 1  B -> 2  Z -> 26
    AA -> 27    AB -> 28
    Input: columnNumber = 701   Output: "ZY"

     */


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
    //Memory Usage: 39.2 MB, less than 5.29% of Java online submissions for Excel Sheet Column Title.

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
    //Memory Usage: 36.6 MB, less than 51.92% of Java online submissions for Excel Sheet Column Title.

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder("");
        while (n > 0) {
            n = n-1;
            sb.append((char)('A'+ n % 26));
            n = n/26;
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {

        //int testData  = 26;
        int testData  = 28;
        ExcelSheetColumn solution = new ExcelSheetColumn();
        String result = solution.convertToTitle(testData);

        System.out.printf("ExcelSheetColumn  %s is the column %s \n", testData,result);

        // Test case 1
        int columnNumber1 = 1;
        String title1 = solution.convertToTitle(columnNumber1);
        System.out.println("Excel Sheet Column Title Test Case 1: " + title1);  // Expected output: "A"

        // Test case 2
        int columnNumber2 = 28;
        String title2 = solution.convertToTitle(columnNumber2);
        System.out.println("Excel Sheet Column Title Test Case 2: " + title2);  // Expected output: "AB"

        // Test case 3
        int columnNumber3 = 701;
        String title3 = solution.convertToTitle(columnNumber3);
        System.out.println("Excel Sheet Column Title Test Case 3: " + title3);  // Expected output: "ZY"

        // Test case 4
        int columnNumber4 = 2147483647;
        String title4 = solution.convertToTitle(columnNumber4);
        System.out.println("Excel Sheet Column Title Test Case 4: " + title4);  // Expected output: "FXSHRXW"

    }

}
