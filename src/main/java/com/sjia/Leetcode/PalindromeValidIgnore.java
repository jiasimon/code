package com.sjia.Leetcode;

public class PalindromeValidIgnore {

    // #125 https://leetcode.com/problems/valid-palindrome/

    // considering only alphanumeric characters and ignoring cases.
    // Here we define empty string as valid palindrome

    // Runtime: 37 ms, faster than 14.21% of Java online submissions for Valid Palindrome.
    //Memory Usage: 44.8 MB, less than 5.01% of Java online submissions for Valid Palindrome.

    public boolean isPalindrome(String s) {
        String filterStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String revertStr = new StringBuilder(filterStr).reverse().toString();
        return filterStr.equals(revertStr) ;
    }


    // Runtime: 11 ms, faster than 31.09% of Java online submissions for Valid Palindrome.
    //Memory Usage: 40.9 MB, less than 12.38% of Java online submissions for Valid Palindrome.

/*
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }*/



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
