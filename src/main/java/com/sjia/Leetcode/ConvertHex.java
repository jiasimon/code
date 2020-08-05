package com.sjia.Leetcode;

public class ConvertHex {
    // #405 https://leetcode.com/problems/convert-a-number-to-hexadecimal/

    // Runtime: 1 ms, faster than 48.00% of Java online submissions for Convert a Number to Hexadecimal.
    //Memory Usage: 36.6 MB, less than 60.72% of Java online submissions for Convert a Number to Hexadecimal.
    public String toHex(int num) {
        if (num ==0) return "0";
        String result = "";
        String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

        while ( num !=0 ) {
            result = hex[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }


}
