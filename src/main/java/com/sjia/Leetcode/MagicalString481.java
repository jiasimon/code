package com.sjia.Leetcode;

public class MagicalString481 {
    // #481. Magical String     https://leetcode.com/problems/magical-string/description/

    /*
    The first few elements of s is s = "1221121221221121122……". If we group the consecutive 1's and 2's in s, it will be "1 22 11 2 1 22 1 22 11 2 11 22 ......" and the occurrences of 1's or 2's in each group are "1 2 2 1 1 2 1 2 2 1 2 2 ......". You can see that the occurrence sequence is s itself.

    Given an integer n, return the number of 1's in the first n number in the magical string s.

    Input: n = 6        Output: 3
    Explanation: The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.

    Input: n = 1        Output: 1

    1 <= n <= 100000
     */

    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;

        StringBuilder magicString = new StringBuilder("122");
        int pointer = 2; // Pointing to the next number to append
        int result = 1;

        while (magicString.length() < n) {
            int count = magicString.charAt(pointer) - '0'; // Count of the next number to append
            char appendChar = (char) ('1' + '2' - magicString.charAt(magicString.length() - 1)); // '1'->'2', '2'->'1'

            for (int i = 0; i < count; i++) {
                magicString.append(appendChar);
                if (magicString.length() <= n && appendChar == '1') {
                    result++;
                }
            }
            pointer++;
        }
        return result;
    }

    public static void main(String[] args) {
        MagicalString481 solution = new MagicalString481();
        int n = 6;

        int result = solution.magicalString(n);
        System.out.println("Magical String Count: " + result);
    }



}
