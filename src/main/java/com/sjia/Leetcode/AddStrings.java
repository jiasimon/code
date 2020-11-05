package com.sjia.Leetcode;

public class AddStrings {
    // #415 https://leetcode.com/problems/add-strings/  #fb
    // The length of both num1 and num2 is < 5100.
    //Both num1 and num2 contains only digits 0-9.
    //Both num1 and num2 does not contain any leading zero.


    // Runtime: 2 ms, faster than 96.67% of Java online submissions for Add Strings.
    //Memory Usage: 39.5 MB, less than 40.37% of Java online submissions for Add Strings.
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1, carry =0;
        StringBuilder  result = new StringBuilder();
        while ( i >=0 || j >=0 || carry !=0 ) {
            int x=0, y=0;
            if (i >=0) x = Character.getNumericValue(num1.charAt(i));
            else x =0;
            if (j>=0) y = Character.getNumericValue(num2.charAt(j));
            else y = 0;
            int tmp = x + y + carry;
            result.append(tmp %10);
            carry = tmp/10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }


}
