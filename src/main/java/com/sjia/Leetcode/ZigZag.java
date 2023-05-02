package com.sjia.Leetcode;

// 6. Zigzag Conversion  https://leetcode.com/problems/zigzag-conversion/description/
/*
        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"

        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"

*/


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

    public static String convert2(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
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
        String testData = "PAYPALISHIRING";
//        String testData2 = "ABCDEFGHIJKLMN";
        String result = convert2(testData ,4);
        System.out.println("Converted Zigzag is: " + result);
    }



}
