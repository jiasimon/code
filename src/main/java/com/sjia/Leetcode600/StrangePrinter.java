package com.sjia.Leetcode600;

public class StrangePrinter {
    // #664. Strange Printer    https://leetcode.com/problems/strange-printer/description/
    /*
    There is a strange printer with the following two special properties:

    The printer can only print a sequence of the same character each time.
    At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
    Given a string s, return the minimum number of turns the printer needed to print it.

    Input: s = "aaabbb"     Output: 2
    Explanation: Print "aaa" first and then print "bbb".

    Input: s = "aba"        Output: 2
    Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.

    1 <= s.length <= 100
     */


    // dp, follow up
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = len;  // Initialize with maximum operations (worst case: print each character separately)

                for (int k = i; k < j; k++) {
                    int total = dp[i][k] + dp[k + 1][j];
                    if (s.charAt(k) == s.charAt(j)) {
                        total--;
                    }
                    dp[i][j] = Math.min(dp[i][j], total);
                }
            }
        }

        return dp[0][n - 1];
    }


    public static void main(String[] args) {
        StrangePrinter solution = new StrangePrinter();

        // Test case 1
        String s1 = "aaabbb";
        System.out.println("Test case 1: " + solution.strangePrinter(s1));  // Expected output: 2

        // Test case 2
        String s2 = "aba";
        System.out.println("Test case 2: " + solution.strangePrinter(s2));  // Expected output: 2

        // Test case 3
        String s3 = "abcabc";
        System.out.println("Test case 3: " + solution.strangePrinter(s3));  // Expected output: 5

        // Test case 4
        String s4 = "aaaa";
        System.out.println("Test case 4: " + solution.strangePrinter(s4));  // Expected output: 1

        // Test case 5
        String s5 = "abacada";
        System.out.println("Test case 5: " + solution.strangePrinter(s5));  // Expected output: 4
    }

}
