package com.sjia.Leetcode;

public class ReverseWordsInString3 {
    // #557. Reverse Words in a String III  https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

    /*
    Input: s = "Let's take LeetCode contest"    Output: "s'teL ekat edoCteeL tsetnoc"

    Input: s = "Mr Ding"        Output: "rM gniD"
     */

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(reverseString(word)).append(" ");
        }
        return result.toString().trim();
    }

    private String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseWordsInString3 solution = new ReverseWordsInString3();

        String testString = "Let's take LeetCode contest";
        System.out.println("Test Case 1: " + solution.reverseWords(testString)); // Output: "s'teL ekat edoCteeL tsetnoc"
    }


}
