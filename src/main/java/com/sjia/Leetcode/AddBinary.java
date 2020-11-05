package com.sjia.Leetcode;

public class AddBinary {

    // #67 https://leetcode.com/problems/add-binary/    #fb
    // a = "1010", b = "1011" , Output: "10101"
    // 1 <= a.length, b.length <= 10^4


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


    // java.lang.NumberFormatException: For input string:
/*
    static String addBinary(String a, String b) {
//        int a1 = Integer.parseInt(a, 2);
//        int b1 = Integer.parseInt(b,2);
//        return  Integer.toBinaryString(a1+b1);
        long a1 = Long.parseLong(a, 2);
        long b1 = Long.parseLong(b, 2);
        return Long.toBinaryString(a1+b1);

    }*/



    public static void main(String[] args) {
        String testData = "11";
        String testData2 = "1";
        String result = addBinary(testData,testData2);
        System.out.printf( "Binary %s plus %s  is : %s ", testData,testData2, result);
    }

}
