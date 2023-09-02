package com.sjia.Leetcode;

public class AddStrings {
    // #415. Add Strings https://leetcode.com/problems/add-strings/  #fb


    /*
    Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

    You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

    Input: num1 = "456", num2 = "77"    Output: "533"
    Input: num1 = "0", num2 = "0"       Output: "0"

    1 <= num1.length, num2.length <= 10000
    num1 and num2 consist of only digits.
    num1 and num2 don't have any leading zeros except for the zero itself.


    */


    // Runtime: 2 ms, faster than 91.73% of Java online submissions for Add Strings.
    //Memory Usage: 39.4 MB, less than 17.72% of Java online submissions for Add Strings.
    public String addStrings2(String num1, String num2) {
        int i = num1.length()-1, j= num2.length()-1, carry = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0 || carry !=0) {
            int a, b;
            if (i>=0) a = Character.getNumericValue(num1.charAt(i));
            else a =0;
            if (j >= 0) b= Character.getNumericValue(num2.charAt(j));
            else b=0;
            int tmp = a+b+carry;
            res.append(tmp%10);
            carry = tmp/10;
            i--;
            j--;
        }
        return res.reverse().toString();

    }


    // Runtime: 2 ms, faster than 96.67% of Java online submissions for Add Strings.
    //Memory Usage: 39.5 MB, less than 40.37% of Java online submissions for Add Strings.
    public String addStrings_old(String num1, String num2) {
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



    // StringBuilder, sb.insert(0, tmp)
    // 4 ms, 46.17%; 43.4 MB, 46.51%
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int currentDigit = sum % 10;

            result.insert(0, currentDigit);
            i--;
            j--;
        }

        return result.toString();
    }



    public static void main(String[] args) {
        AddStrings solution = new AddStrings();
        String num1 = "123";
        String num2 = "456";
        String sum = solution.addStrings(num1, num2);
        System.out.println("Sum of strings: " + sum);
    }


}
