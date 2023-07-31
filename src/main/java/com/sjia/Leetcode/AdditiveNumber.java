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

        return false;
    }


    public static void main(String[] args) {
        AdditiveNumber solution = new AdditiveNumber();
        System.out.println(solution.isAdditiveNumber("112358")); // Output: true
        System.out.println(solution.isAdditiveNumber("199100199")); // Output: true
        System.out.println(solution.isAdditiveNumber("1023")); // Output: false
    }


}
