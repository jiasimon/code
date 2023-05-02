package com.sjia.Leetcode;

public class StringtoInteger {
    // #8 https://leetcode.com/problems/string-to-integer-atoi/

    // Input: str = "   -42"    Output: -42
    // str = "4193 with words"  Output: 4193
    // str = "words and 987"    Output: 0
    // the first non-whitespace character is 'w', which is not a numerical digit or a +/- sign.
    // Input: str = "-91283472332"  Output: -2147483648


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
    //Memory Usage: 38.7 MB, less than 5.86% of Java online submissions for String to Integer (atoi).
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        int index = 0, sign = 1, total = 0;

        while (index < s.length() && s.charAt(index) == ' '){
            index++;
        }
        if (index == s.length())  return 0; // "  "

        // handle sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-'){
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while(index < s.length()) {
            // check char , charAt - '0'
            int d = s.charAt(index) - '0';
            if (d < 0 || d > 9) break;
            if(Integer.MAX_VALUE/10 < total ||
                    Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < d) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = 10 * total + d;
            index++;
        }
        return sign * total;

    }

}
