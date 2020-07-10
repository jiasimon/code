package com.sjia.Leetcode;

public class ZigZag {
    static String convert(String s, int nRows) {
        if (nRows <= 1) return s;
        String res = "";
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; ++i) {
            for (int j = i; j < s.length(); j += size) {
                res += s.charAt(j);
                int tmp = j + size - 2 * i;
                if (i != 0 && i != nRows - 1 && tmp < s.length()) res += s.charAt(tmp);
            }
        }
        return res;
    }

    //0     6        12
    //
    //1   5 7   11   13
    //
    //2 4   8 10     14
    //
    //3     9        15

    // n=3, PAHNAPLSIIGYIR
    // n=4, PINALSIGYAHRPI

    public static void main(String[] args) {
        //String testData = "PAYPALISHIRING";
        String testData2 = "ABCDEFGHIJKLMN";
        String result = convert(testData2 ,4);
        System.out.println("Converted Zigzag is: " + result);
    }



}
