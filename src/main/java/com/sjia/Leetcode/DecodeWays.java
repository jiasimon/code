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

        // Edge case: if the string is empty or starts with '0', return 0
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // dp[i] represents the number of ways to decode the substring s[0...i-1]
        int[] dp = new int[n + 1];

        // Base case: there is only one way to decode an empty string
        dp[0] = 1;

        // Initialize the dp array for the first character
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // Check if we can decode the current character alone
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            // Check if we can decode the current and previous character together
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "226";
        int numDecodings = numDecodings(s);
        System.out.println("Number of Decodings: " + numDecodings); // output 3

        String s2 = "06";
        int res = numDecodings(s2);
        System.out.println("Number of Decodings: " + res);
    }

}
