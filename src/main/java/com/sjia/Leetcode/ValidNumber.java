package com.sjia.Leetcode;

public class ValidNumber {
    // #65. Valid Number  https://leetcode.com/problems/valid-number/description/
    /*


    For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

    Given a string s, return true if s is a valid number.

    1 <= s.length <= 20 , s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
     */

    // 1490 / 1492 testcases passed
    public static boolean isNumber(String s) {
        s = s.trim();


        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                numberSeen = true;
                numberAfterE = true;
            } else if (c == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }

    public static void main(String[] args) {
        String s1 = "0"; // true
        String s2 = " 0.1 "; // true
        String s3 = "abc"; // false
        String s4 = "1 a"; // false
        String s5 = "2e10"; // true



        System.out.println("Valid Number: " + isNumber(s1));
        System.out.println("Valid Number: " + isNumber(s2));
        System.out.println("Valid Number: " + isNumber(s3));
        System.out.println("Valid Number: " + isNumber(s4));
        System.out.println("Valid Number: " + isNumber(s5));

    }


}
