package com.sjia.Leetcode;

public class PalindromeShortest {

    // #214 https://leetcode.com/problems/shortest-palindrome/

    // Input: "aacecaaa"
    //Output: "aaacecaaa"

    // Runtime: 210 ms, faster than 34.95% of Java online submissions for Shortest Palindrome.
    //Memory Usage: 39.8 MB, less than 41.73% of Java online submissions for Shortest Palindrome.

    // second run, Runtime: 213 ms, faster than 33.64% of Java online submissions for Shortest Palindrome.
    //Memory Usage: 40.2 MB, less than 17.58% of Java online submissions for Shortest Palindrome.

    static String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        for ( int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(reverse.substring(i))) {
                return new StringBuilder(s.substring(n - i)).reverse() + s;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        //String testData = "aacecaaa";
        //String testData = "abacd";
        String testData  = "abcd";
        String result = shortestPalindrome(testData);

        System.out.printf(" input %s , PalindromeShortest is %s ", testData, result);
    }


}
