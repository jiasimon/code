package com.sjia.Leetcode600;

public class RemoveTrailingZeros {
    // #2710. Remove Trailing Zeros From a String   https://leetcode.com/problems/remove-trailing-zeros-from-a-string/description/
    /*
    Given a positive integer num represented as a string, return the integer num without trailing zeros as a string.

    Input: num = "51230100"     Output: "512301"

    Input: num = "123"          Output: "123"

    1 <= num.length <= 1000
    num consists of only digits.
     */

    // for loop
    public String removeTrailingZeros(String num) {
        int i = num.length() -1 ;
        for (; i>=0 && num.charAt(i) == '0'; i--  ){

        }
        return num.substring(0, i+1);
    }


    public static void main(String[] args) {
        RemoveTrailingZeros solution = new RemoveTrailingZeros();

        // Test case 1
        String num1 = "123000";
        System.out.println("Test case 1: " + solution.removeTrailingZeros(num1)); // Expected output: "123"

        // Test case 2
        String num2 = "100200";
        System.out.println("Test case 2: " + solution.removeTrailingZeros(num2)); // Expected output: "1002"

        // Test case 3
        String num3 = "45600000";
        System.out.println("Test case 3: " + solution.removeTrailingZeros(num3)); // Expected output: "456"

        // Test case 4
        String num4 = "7890";
        System.out.println("Test case 4: " + solution.removeTrailingZeros(num4)); // Expected output: "789"

        // Test case 5
        String num5 = "100000";
        System.out.println("Test case 5: " + solution.removeTrailingZeros(num5)); // Expected output: "1"

        String num6 = "0";
        System.out.println("Test case 6: " + solution.removeTrailingZeros(num6)); // Expected output: ""  ?
    }

}
