package com.sjia.Leetcode;

public class BitwiseANDNumbersRange {
    // #201. Bitwise AND of Numbers Range   https://leetcode.com/problems/bitwise-and-of-numbers-range/
    /*
    https://leetcode.com/problems/bitwise-and-of-numbers-range/
    Input: left = 5, right = 7      Output: 4
    Input: left = 0, right = 0      Output: 0
    Input: left = 1, right = 2147483647 Output: 0

    Note: this problem is asking us to find the common prefix of m and n 's binary code.
     */


    // 6ms, 100.00% ; 42.63mb, 87.56%
    static public int rangeBitwiseAnd(int left, int right) {
        int shift =0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift ;

    }


    public static void main(String[] args) {
        // Test Case 1: m = 5, n = 7
        int m1 = 5;
        int n1 = 7;
        int result1 = rangeBitwiseAnd(m1, n1);
        System.out.println("Bitwise AND of " + m1 + " and " + n1 + ": " + result1);

        // Test Case 2: m = 0, n = 1
        int m2 = 0;
        int n2 = 1;
        int result2 = rangeBitwiseAnd(m2, n2);
        System.out.println("Bitwise AND of " + m2 + " and " + n2 + ": " + result2);

        // Test Case 3: m = 10, n = 15
        int m3 = 10;
        int n3 = 15;
        int result3 = rangeBitwiseAnd(m3, n3);
        System.out.println("Bitwise AND of " + m3 + " and " + n3 + ": " + result3);
    }


}
