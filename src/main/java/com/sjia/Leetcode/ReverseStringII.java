package com.sjia.Leetcode;

public class ReverseStringII {
    // #541. Reverse String II  https://leetcode.com/problems/reverse-string-ii/description/

    /*
    Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

    If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

    Input: s = "abcdefg", k = 2     Output: "bacdfeg"
    Input: s = "abcd", k = 2        Output: "bacd"
     */

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int start = 0; start < n; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, n - 1);

            while (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseStringII solution = new ReverseStringII();

        String s = "abcdefg";
        int k = 2;

        String reversedString = solution.reverseStr(s, k);
        System.out.println("Reversed string: " + reversedString);
    }


}
