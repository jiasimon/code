package com.sjia.Leetcode;

public class LongestPalindrome {

    // #5 https://leetcode.com/problems/longest-palindromic-substring/

    // Given a string s, find the longest palindromic substring in s.
    // You may assume that the maximum length of s is 1000.


    // Cut point,  Runtime: 23 ms, faster than 84.80% of Java online submissions for Longest Palindromic Substring.
    //Memory Usage: 39.9 MB, less than 41.01% of Java online submissions for Longest Palindromic Substring.
/*
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
    }*/



    // extend
    // Runtime: 22 ms, faster than 91.29% of Java online submissions for Longest Palindromic Substring.
    //Memory Usage: 38 MB, less than 71.62% of Java online submissions for Longest Palindromic Substring.

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }




    // Manacher's Algorithm


    public static void main(String[] args) {

        // babad, cbbd
        //String testData = "baacecaaa";
        //String testData = "abacd"; dcaba
        String testData  = "baacecaaa";
        LongestPalindrome solution = new LongestPalindrome();
        String result = solution.longestPalindrome(testData);

        System.out.printf(" input %s , PalindromeShortest is %s ", testData, result);
    }

}
