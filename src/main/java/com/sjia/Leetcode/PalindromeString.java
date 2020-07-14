package com.sjia.Leetcode;

public class PalindromeString {

    static boolean isPalindrome(String input) {

        StringBuilder output = new StringBuilder(input).reverse();
        if ( input.equals(output.toString())) return true;
        else return false;
    }




    public static void main(String[] args) {
        // int range:  -2147483648～2147483647

        //String testData = "";
        //String testData  = " a  ";
        //String testData  = " a ";
        String testData  = "abba ";
        //String testData  = "212";
        boolean result = isPalindrome(testData);

        System.out.printf(" input %s isPalindrome: %b ", testData, result);
    }
}
