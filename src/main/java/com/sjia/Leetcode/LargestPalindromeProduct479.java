package com.sjia.Leetcode;

public class LargestPalindromeProduct479 {
    // #479. Largest Palindrome Product     https://leetcode.com/problems/largest-palindrome-product/

    /*
    Given an integer n, return the largest palindromic integer that can be represented as the product of two n-digits integers. Since the answer can be very large, return it modulo 1337.

    Input: n = 2    Output: 987
    Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

    Input: n = 1    Output: 9

    1 <= n <= 8
     */



    //
    // 92 ms, 34.55%; 42.8 MB, 25.45%
        public int largestPalindrome(int n) {
            if (n == 1) {
                return 9;
            }
            int upper = (int) Math.pow(10, n) - 1;
            int lower = (int) Math.pow(10, n - 1);

            for (int a = upper - 1; a >= lower; a--) {
                long palindrome = createPalindrome(a);

                for (long b = upper; b * b >= palindrome; b--) {
                    if (palindrome % b == 0) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
            return -1;
        }

        private long createPalindrome(int n) {
            String s = n + new StringBuilder().append(n).reverse().toString();
            return Long.parseLong(s);
        }

        public static void main(String[] args) {
            LargestPalindromeProduct479 solution = new LargestPalindromeProduct479();
            int n = 2;

            int largestPal = solution.largestPalindrome(n);
            System.out.println("Largest Palindrome: " + largestPal);
        }

}
