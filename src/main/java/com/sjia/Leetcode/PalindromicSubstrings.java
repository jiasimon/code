package com.sjia.Leetcode;

public class PalindromicSubstrings {

    // #647 https://leetcode.com/problems/palindromic-substrings/

    // Runtime: 3 ms, faster than 81.42% of Java online submissions for Palindromic Substrings.
    //Memory Usage: 37.6 MB, less than 70.93% of Java online submissions for Palindromic Substrings.

    public int countSubstrings(String s) {
        int result = 0, L = s.length();
        for (int cut = 0;  cut < 2*L-1 ; cut++ ){
            int left = cut / 2;
            int right = left + cut %2;
            while (left >=0 && right < L && (s.charAt(left) == s.charAt(right) )) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //String testData  = "aab";
        String testData  = "adbbc";
        PalindromicSubstrings solution = new PalindromicSubstrings();
        int result = solution.countSubstrings(testData);

        System.out.printf(" input %s : count Palindromic Substrings: %s ", testData, result);
    }

}
