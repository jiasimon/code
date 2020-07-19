package com.sjia.Leetcode;

public class LongestPalindrom {

    // #5 https://leetcode.com/problems/longest-palindromic-substring/

    // Given a string s, find the longest palindromic substring in s.
    // You may assume that the maximum length of s is 1000.


    // Cut point,  Runtime: 23 ms, faster than 84.80% of Java online submissions for Longest Palindromic Substring.
    //Memory Usage: 39.9 MB, less than 41.01% of Java online submissions for Longest Palindromic Substring.

    static String longestPalindrome(String s) {
        if ( s == null || s.length() < 1) return "";
        int maxL = 0, L = s.length();
        String result = "";
        for (int cut = 0;  cut < 2*L-1 ; cut++ ){
            int left = cut / 2;
            int right = left + cut %2;
            while (left >=0 && right < L && (s.charAt(left) == s.charAt(right) )) {
                left--;
                right++;
            }
            if (right - left -1 > maxL) {
                result = s.substring(left+1, right );
                maxL = right - left -1;
            }
        }
        return result;
    }


    // Manacher's Algorithm


    public static void main(String[] args) {

        // babad, cbbd
        //String testData = "baacecaaa";
        //String testData = "abacd"; dcaba
        String testData  = "baacecaaa";
        String result = longestPalindrome(testData);

        System.out.printf(" input %s , PalindromeShortest is %s ", testData, result);
    }

}
