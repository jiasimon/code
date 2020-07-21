package com.sjia.Leetcode;

public class AddBinary {

    // #67 https://leetcode.com/problems/add-binary/

    // Runtime: 2 ms, faster than 86.61% of Java online submissions for Add Binary.
    //Memory Usage: 40.1 MB, less than 6.37% of Java online submissions for Add Binary.

    static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i=a.length()-1, j=b.length()-1; i>=0 || j>=0 ; i--, j--) {
            int sum = carry;
            if (i>=0) {
                sum += a.charAt(i) - '0';
            }
            if (j>=0) {
                sum += b.charAt(j) - '0';
            }
            result.append(sum % 2);
            carry = sum/2;
        }
        if (carry==1) result.append("1");
        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String testData = "1010";
        String testData2 = "1011";
        String result = addBinary(testData,testData2);
        System.out.printf( "Binary %s plus %s  is : %s ", testData,testData2, result);
    }

}
