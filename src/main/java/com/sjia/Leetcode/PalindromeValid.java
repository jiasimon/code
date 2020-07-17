package com.sjia.Leetcode;

public class PalindromeValid {

    // #680 https://leetcode.com/problems/valid-palindrome-ii/

    // Runtime: 11 ms, faster than 33.72% of Java online submissions for Valid Palindrome II.
    //Memory Usage: 52.1 MB, less than 9.72% of Java online submissions for Valid Palindrome II.

    static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return checkPalindrome(s, i + 1, j) || checkPalindrome(s, i, j - 1);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    static boolean checkPalindrome(String s, int left, int right ) {
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }



    public static void main(String[] args) {

        //String testData  = " a  ";
        //String testData  = "aA";
        //String testData  = "abad ";
        String testData  = "acbca";
        boolean result = validPalindrome(testData);

        System.out.printf(" input %s isPalindrome: %b ", testData, result);
    }


}
