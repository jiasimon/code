package com.sjia.Leetcode;

public class PalindromeBreak {

    // #1328 https://leetcode.com/problems/break-a-palindrome/

    //Runtime: 4 ms, faster than 12.96% of Java online submissions for Break a Palindrome.
    //Memory Usage: 39.2 MB, less than 7.77% of Java online submissions for Break a Palindrome.

/*
    static String breakPalindrome(String palindrome) {
        if (palindrome.length()<=1) return "";
        int N = palindrome.length();
        String result ="";
        for (int i=0; i<=N/2; i++) {
            if(i==N/2) {
                result = palindrome.substring(0,N-1) + "b";
                break;
            }
            if (palindrome.charAt(i) != 'a') {
                result = palindrome.substring(0,i) + "a" +palindrome.substring(i+1);
                break;
            }
        }
        return result;
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Break a Palindrome.
    //Memory Usage: 37.2 MB, less than 88.59% of Java online submissions for Break a Palindrome.

    static String breakPalindrome(String palindrome) {
        if (palindrome.length()<=1) return "";
        int N = palindrome.length();
        char[] s = palindrome.toCharArray();
        for (int i=0; i<=N/2; i++) {
            if(i==N/2) {
                s[N-1] = 'b';
                break;
            }
            if (palindrome.charAt(i) != 'a') {
                s[i] = 'a';
                break;
            }
        }
        return String.valueOf(s);
    }



    public static void main(String[] args) {

        //String testData = "baab";
        //String testData  = "abba";
        String testData  = "baab";
        String result = breakPalindrome(testData);

        System.out.printf(" input %s breakPalindrome: %s ", testData, result);
    }


}
