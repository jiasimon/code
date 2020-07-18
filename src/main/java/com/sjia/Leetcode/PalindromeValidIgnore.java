package com.sjia.Leetcode;

public class PalindromeValidIgnore {

    // #125 https://leetcode.com/problems/valid-palindrome/

    // considering only alphanumeric characters and ignoring cases.
    // Here we define empty string as valid palindrome

    // Runtime: 37 ms, faster than 14.21% of Java online submissions for Valid Palindrome.
    //Memory Usage: 44.8 MB, less than 5.01% of Java online submissions for Valid Palindrome.

    public boolean isPalindrome(String s) {
        String filterStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return filterStr.equals(new StringBuilder(filterStr).reverse().toString()) ;
    }


    public static void main(String[] args) {

        //String testData  = " a  ";
        //String testData  = "This is ht";
        //String testData  = "race a car";
        String testData  = "A man, a plan, a canal: Panama";
        PalindromeValidIgnore solution = new PalindromeValidIgnore();

        boolean result = solution.isPalindrome(testData);

        System.out.printf(" input %s isPalindrome: %b ", testData, result);
    }

}
