package com.sjia.Leetcode;

public class DecodedStringAtIndex880 {
    // #880. Decoded String at Index    https://leetcode.com/problems/decoded-string-at-index/description/
    /*
    You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:

    If the character read is a letter, that letter is written onto the tape.
    If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
    Given an integer k, return the kth letter (1-indexed) in the decoded string.

    Input: s = "leet2code3", k = 10     Output: "o"
    Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
    The 10th letter in the string is "o".

    Input: s = "ha22", k = 5            Output: "h"
    Explanation: The decoded string is "hahahaha". The 5th letter is "h".

    Input: s = "a2345678999999999999999", k = 1     Output: "a"
    Explanation: The decoded string is "a" repeated 8301530446056247680 times.

     */

    public String decodeAtIndex(String s, int k) {
        long size = 0; // Length of decoded `s`
        for (final char c : s.toCharArray())
            if (Character.isDigit(c))
                size *= c - '0';
            else
                ++size;
        for (int i = s.length() - 1; i >= 0; --i) {
            k %= size;
            if (k == 0 && Character.isAlphabetic(s.charAt(i)))
                return s.substring(i, i + 1);
            if (Character.isDigit(s.charAt(i)))
                size /= s.charAt(i) - '0';
            else
                --size;
        }
        throw new IllegalArgumentException();
    }



    // K %= N
    public String decodeAtIndex_long(String S, int K) {
        int i;
        long N = 0;
        for (i = 0; N < K; i++) {
            N = Character.isDigit(S.charAt(i)) ? N * (S.charAt(i) - '0') : N + 1;
        }
        for (i--; i > 0; i--) {
            if (Character.isDigit(S.charAt(i))) {
                N /= S.charAt(i) - '0';
                K %= N;
            }
            else {
                if (K % N == 0) {
                    break;
                }
                N--;
            }
        }
        return Character.toString(S.charAt(i));

    }

    public static void main(String[] args) {
        DecodedStringAtIndex880 solution = new DecodedStringAtIndex880();
        String s = "leet2code3";
        int k = 10;
        String decodedChar = solution.decodeAtIndex(s, k);
        System.out.println("Character at position " + k + ": " + decodedChar); // Output: "o"
    }



}
