package com.sjia.Leetcode;

public class ConvertHex {
    // #405 https://leetcode.com/problems/convert-a-number-to-hexadecimal/

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





    public static void main(String[] args) {
        int testData = -1;  //-1 ,32
        ConvertHex solution = new ConvertHex();
        String result = solution.toHex(testData);
        System.out.printf( "testData  %s is   %s ",testData, result );
    }


}
