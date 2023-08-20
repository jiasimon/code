package com.sjia.Leetcode;

import java.util.Stack;

public class DecodeString {
    // #394. Decode String  https://leetcode.com/problems/decode-string/description/

    /*
    Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
    You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

    Input: s = "3[a]2[bc]"      Output: "aaabcbc"
    Input: s = "3[a2[c]]"       Output: "accaccacc"
    Input: s = "2[abc]3[cd]ef"  Output: "abcabccdcdcdef"

    1 <= s.length <= 30
    s consists of lowercase English letters, digits, and square brackets '[]'.
    s is guaranteed to be a valid input.
    All the integers in s are in the range [1, 300].


     */


    // two stack: num, str, StringBuilder
    // 1ms, 78%; 41 MB, 23.84%
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num = 0;
        StringBuilder currentStr = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + ( c - '0');
            } else if ( c == '[') {
                numStack.push(num);
                strStack.push(currentStr.toString());
                num = 0; // reset to 0
                currentStr = new StringBuilder(); // reset to ""
            } else if ( c == ']') {
                int repeat = numStack.pop();
                StringBuilder tmp = new StringBuilder(strStack.pop());
                for (int i = 0; i < repeat; i++) {
                    tmp.append(currentStr);
                }
                currentStr = tmp;

            } else {
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }



    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        String encodedString = "3[a2[c]]";
        String decodedString = solution.decodeString(encodedString);
        System.out.println("Decoded string: " + decodedString); // Output: "accaccacc"

        encodedString = "3[a]2[bc]";
        decodedString = solution.decodeString(encodedString);
        System.out.println("Decoded string: " + decodedString); // Output: "aaabcbc"

        encodedString = "3[a2[c4[d]]]";
        decodedString = solution.decodeString(encodedString);
        System.out.println("Decoded string: " + decodedString); // Output: "acddddcddddacddddcddddacddddcdddd"

    }

}
