package com.sjia.Leetcode;

import java.util.Arrays;

public class ExcelSheetColumn {

    // #168 https://leetcode-cn.com/problems/excel-sheet-column-title/


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
    }

}
