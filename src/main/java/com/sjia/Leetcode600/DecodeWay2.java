package com.sjia.Leetcode600;

public class DecodeWay2 {
    // #639. Decode Ways II     https://leetcode.com/problems/decode-ways-ii/description/
    /*
    'A' -> "1"
    'B' -> "2"
    ...
    'Z' -> "26"

    "AAJF" with the grouping (1 1 10 6)
    "KJF" with the grouping (11 10 6)

    an encoded message may contain the '*' character, which can represent any digit from '1' to '9' ('0' is excluded).
    Given a string s consisting of digits and '*' characters, return the number of ways to decode it.

    Since the answer may be very large, return it modulo 10^9 + 7.

    Input: s = "*"      Output: 9
    Input: s = "1*"     Output: 18
    Input: s = "2*"     Output: 15
     */


    // dp, 2D
    public int numDecodings(String s) {
        final int kMod = 1_000_000_007;
        final int n = s.length();
        // dp[i] := the number of ways to decode s[i..n - 1]
        long[] dp = new long[n + 1];
        dp[n] = 1;
        dp[n - 1] = count(s.charAt(n - 1));

        for (int i = n - 2; i >= 0; --i) {
            dp[i] += count(s.charAt(i), s.charAt(i + 1)) * dp[i + 2];
            dp[i] += count(s.charAt(i)) * dp[i + 1];
            dp[i] %= kMod;
        }

        return (int) dp[0];
    }

    private int count(char c) {
        if (c == '*')
            return 9;
        return c == '0' ? 0 : 1;
    }

    private int count(char c1, char c2) {
        if (c1 == '*' && c2 == '*')
            return 15; // c1c2: [11-19, 21-26]
        if (c1 == '*') {
            if ('0' <= c2 && c2 <= '6')
                return 2; // c1: [1-2]
            else
                return 1; // c1: [1]
        }
        if (c2 == '*') {
            if (c1 == '1')
                return 9; // c2: [1-9]
            if (c1 == '2')
                return 6; // c2: [1-6]
            return 0;
        }
        return (c1 == '1' || (c1 == '2' && c2 <= '6')) ? 1 : 0;
    }


    public static void main(String[] args) {
        DecodeWay2 solution = new DecodeWay2();

        // Test Cases
        String s1 = "1*";
        String s2 = "*";
        String s3 = "2*";
        System.out.println("Test Case 1: " + solution.numDecodings(s1)); // Output: 18
        System.out.println("Test Case 2: " + solution.numDecodings(s2)); // Output: 9
        System.out.println("Test Case 3: " + solution.numDecodings(s3)); // Output: 15
    }


}
