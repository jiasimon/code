package com.sjia.Leetcode;

public class DetectCapital520 {
    // #520. Detect Capital https://leetcode.com/problems/detect-capital/description/

    /*
    We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".
    Given a string word, return true if the usage of capitals in it is right.

    Input: word = "USA"     Output: true
    Input: word = "FlaG"    Output: false
    Input: word = "Flag"    Output: true
     */


    // check UpperCase count
    // 1 ms, 96.18%; 41.3 MB, 23.71%
    public boolean detectCapitalUse(String word) {
        int countUpper = 0;
        int n = word.length();

        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                countUpper++;
            }
        }

        return countUpper == n || countUpper == 0 || (countUpper == 1 && Character.isUpperCase(word.charAt(0)));
    }

    public static void main(String[] args) {
        DetectCapital520 solution = new DetectCapital520();

        String word1 = "USA";
        String word2 = "leetcode";
        String word3 = "Google";

        System.out.println("Is '" + word1 + "' correctly capitalized? " + solution.detectCapitalUse(word1));
        System.out.println("Is '" + word2 + "' correctly capitalized? " + solution.detectCapitalUse(word2));
        System.out.println("Is '" + word3 + "' correctly capitalized? " + solution.detectCapitalUse(word3));
    }

}
