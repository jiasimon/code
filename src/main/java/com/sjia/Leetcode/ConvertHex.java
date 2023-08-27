package com.sjia.Leetcode;

public class ConvertHex {
    // #405. Convert a Number to Hexadecimal https://leetcode.com/problems/convert-a-number-to-hexadecimal/

    /*
    Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

    All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

    Note: You are not allowed to use any built-in library method to directly solve this problem.
     */

    // Runtime: 1 ms, faster than 48.00% of Java online submissions for Convert a Number to Hexadecimal.
    //Memory Usage: 36.6 MB, less than 60.72% of Java online submissions for Convert a Number to Hexadecimal.
    public String toHex(int num) {
        if (num ==0) return "0";
        String result = "";
        String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

        // if use char[], Runtime: 13 ms, faster than 5.21% of Java online submissions for Convert a Number to Hexadecimal.
        //Memory Usage: 39.5 MB, less than 5.36% of Java online submissions for Convert a Number to Hexadecimal.
        // char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        while ( num !=0 ) {
            result = hex[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }



    // negative (Math.pow(2, 32), c = (char)(u + '0')
    // 0 ms, 100%; 40.2 MB, 32.2%
    public String toHex_divide_mode(int n) {
        if (n == 0) return "0";
        long num = n;

        StringBuilder sb = new StringBuilder();

        if(num < 0) num = (long)(Math.pow(2, 32) + num);
        while (num != 0) {
            long u = num % 16;
            char c = (char)(u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            sb.append(c);
            num /= 16;
        }
        return sb.reverse().toString();
    }





    public static void main(String[] args) {
        int testData = 10;  //-1 ,32
        ConvertHex solution = new ConvertHex();
        String result = solution.toHex_divide_mode(testData);
        System.out.printf( "testData  %s is   %s  \n\f",testData, result );

        testData = 18;
        result = solution.toHex_divide_mode(testData);
        System.out.printf( "testData  %s is   %s \n\f",testData, result );

    }


}
