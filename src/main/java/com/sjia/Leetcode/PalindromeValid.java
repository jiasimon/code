package com.sjia.Leetcode;

public class PalindromeValid {

    // #680 https://leetcode.com/problems/valid-palindrome-ii/  #fb
    // Given a non-empty string s, you may delete at most one character.
    // Judge whether you can make it a palindrome
    // The string will only contain lowercase characters a-z. The maximum length of the string is 50000

    // Input: "aba"     Output: True
    // Input: "abca"    Output: True


    // Runtime: 11 ms, faster than 33.72% of Java online submissions for Valid Palindrome II.
    //Memory Usage: 52.1 MB, less than 9.72% of Java online submissions for Valid Palindrome II.


    // no change, second run Runtime: 7 ms, faster than 75.12% of Java online submissions for Valid Palindrome II.
    //Memory Usage: 39.7 MB, less than 91.42% of Java online submissions for Valid Palindrome II.

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



    // Runtime: 7 ms, faster than 38.20% of Java online submissions for Valid Palindrome II.
    //Memory Usage: 39.2 MB, less than 91.37% of Java online submissions for Valid Palindrome II.
    public boolean validPalindrome2(String s) {
        int i=0, j=s.length() - 1;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return helperPalindrome(s, i+1,j) || helperPalindrome(s, i, j-1);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean helperPalindrome(String s, int left, int right) {
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right--;
            }
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
