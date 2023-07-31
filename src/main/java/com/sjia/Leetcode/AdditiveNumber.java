package com.sjia.Leetcode;

public class AdditiveNumber {
    // #306. Additive Number    https://leetcode.com/problems/additive-number/
    /*
    An additive number is a string whose digits can form an additive sequence.

    A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

    Given a string containing only digits, return true if it is an additive number or false otherwise.

    Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

    Input: "112358" Output: true
    Input: "199100199"  Output: true
    The additive sequence is: 1, 99, 100, 199.
    1 + 99 = 100, 99 + 100 = 199
     */



    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) { // i is the length of the first number
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            long firstNum = Long.parseLong(num.substring(0,i));
            // j is the length of the second number
            for (int j=1; Math.max(i,j) <= n-i-j; j++ ) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                long secondNum = Long.parseLong((num.substring(i,i+j)));
                if (isAdditive(num.substring(i + j), firstNum, secondNum)) {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean isAdditive(String num, long firstNum, long secondNum) {
        // If there's nothing left, empty  in the string, it means all parts are additive.
        if (num.length() == 0) {
            return true;
        }

        long sum = firstNum + secondNum;
        String sumStr = String.valueOf(sum);

        if (!num.startsWith(sumStr)) {
            return false; // The remaining string should start with the sum of the first two numbers.
        }

        // recursive
        return isAdditive(num.substring(sumStr.length()), secondNum, sum);

    }


    public static void main(String[] args) {
        AdditiveNumber solution = new AdditiveNumber();
        System.out.println(solution.isAdditiveNumber("112358")); // Output: true
        System.out.println(solution.isAdditiveNumber("199100199")); // Output: true
        System.out.println(solution.isAdditiveNumber("1023")); // Output: false
    }


}
