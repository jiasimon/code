package com.sjia.Leetcode;

public class PalindromeRemoveSubseq {

    // #1332 Remove Palindromic Subsequences
    // https://leetcode.com/problems/remove-palindromic-subsequences/
    // 0 <= s.length <= 1000
    // s only consists of letters 'a' and 'b'
    // Given a string s consisting only of letters 'a' and 'b'.
    // In a single step you can remove one palindromic subsequence from s.
    // Return the minimum number of steps to make the given string empty.


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Palindromic Subsequences.
    //Memory Usage: 37.3 MB, less than 54.76% of Java online submissions for Remove Palindromic Subsequences.

    public int removePalindromeSub(String s) {
        if ( s.isEmpty()) return 0;
        else if ( isPalindrome(s) ) return 1;
        else return 2;
    }

    boolean isPalindrome(String input) {
        String reverseStr = new StringBuilder(input).reverse().toString();
        return input.equals(reverseStr) ;
    }

    public static void main(String[] args) {

        //String testData = "";
        //String testData  = "abbab";
        String testData  = "aba";
        PalindromeRemoveSubseq solution = new PalindromeRemoveSubseq();
        int result = solution.removePalindromeSub(testData);

        System.out.printf(" input %s isPalindrome: %s ", testData, result);
    }

}
