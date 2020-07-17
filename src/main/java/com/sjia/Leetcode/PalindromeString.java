package com.sjia.Leetcode;

public class PalindromeString {

    static boolean isPalindrome(String input) {
        String reverseStr = new StringBuilder(input).reverse().toString();
        return input.equals(reverseStr) ;
    }

/*
    static boolean isPalindrome(String input) {
        if (input == null) {
            System.out.println("Input is Null, please provide a valid string");
            return false;
        }

        if(input.isEmpty()) return true; // if String is "" , return true ?
        // input.toLowerCase() if ignore case
        //

        // input.replaceAll("\\s+", ""); //if ignore whitespace

        int i = 0, j = input.length()-1;
        while (i < j) {
            if ( input.charAt(i)!= input.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }*/


    public static void main(String[] args) {

        //String testData = "";
        //String testData  = " a  ";
        //String testData  = "aA";
        //String testData  = "abba ";
        //String testData  = null;
        String testData  = "aBa";
        boolean result = isPalindrome(testData);

        System.out.printf(" input %s isPalindrome: %b ", testData, result);
    }
}
