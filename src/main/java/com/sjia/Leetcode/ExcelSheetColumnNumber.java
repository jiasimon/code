package com.sjia.Leetcode;

public class ExcelSheetColumnNumber {

    // #171. Excel Sheet Column Number https://leetcode.com/problems/excel-sheet-column-number

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

    public int titleToNumber2(String columnTitle) {
        int res =0;
        for (int i=0 ; i < columnTitle.length(); i++ ) {
            int num = columnTitle.charAt(i) - 'A' +1;
            res = res * 26 + num;
        }
        return res;
    }


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
        System.out.println();

        ExcelSheetColumnNumber solution = new ExcelSheetColumnNumber();
        // Test case 1
        String columnTitle1 = "A";
        int number1 = solution.titleToNumber(columnTitle1);
        System.out.println("Excel Sheet Column Number Test Case 1: " + number1);  // Expected output: 1

        // Test case 2
        String columnTitle2 = "AB";
        int number2 = solution.titleToNumber(columnTitle2);
        System.out.println("Excel Sheet Column Number Test Case 2: " + number2);  // Expected output: 28

        // Test case 3
        String columnTitle3 = "ZY";
        int number3 = solution.titleToNumber(columnTitle3);
        System.out.println("Excel Sheet Column Number Test Case 3: " + number3);  // Expected output: 701

        // Test case 4
        String columnTitle4 = "FXSHRXW";
        int number4 = solution.titleToNumber(columnTitle4);
        System.out.println("Excel Sheet Column Number Test Case 4: " + number4);  // Expected output: 2147483647


    }

}
