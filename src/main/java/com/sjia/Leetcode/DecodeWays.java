package com.sjia.Leetcode;

public class DecodeWays {
    //  #91. Decode Ways   https://leetcode.com/problems/decode-ways/
    /*
    A message containing letters from A-Z can be encoded into numbers using the following mapping:

    'A' -> "1"
    'B' -> "2"
    ...
    'Z' -> "26"

    Input: s = "12"
    Output: 2
    Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

    Input: s = "226"
    Output: 3
    Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

    Input: s = "06"
    Output: 0
    Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

     */


    public static int numDecodings(String s) {
        int n = s.length();

        return n;
    }

    public static void main(String[] args) {
        String s = "226";
        int numDecodings = numDecodings(s);
        System.out.println("Number of Decodings: " + numDecodings); // output 3

        String s2 = "06";
        int res = numDecodings(s2);
        System.out.println("Number of Decodings: " + res); // output 0
    }

}
