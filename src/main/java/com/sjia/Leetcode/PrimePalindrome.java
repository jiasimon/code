package com.sjia.Leetcode;

public class PrimePalindrome {

    // #866 https://leetcode.com/problems/prime-palindrome/
    // 1 <= N <= 10^8

    // Runtime: 32 ms, faster than 83.39% of Java online submissions for Prime Palindrome.
    // Memory Usage: 39.1 MB, less than 18.69% of Java online submissions for Prime Palindrome.

    static int primePalindrome(int N) {
        if (N==1 || N==2) return 2;
        while(true) {
            if ( N > 100000 && N < 1000000) N=1000000;
            else if ( N > 10000000 && N < 100000000) N=100000000;
            if ( isPalindrome(N) && isPrime(N) ) {
                return N;
            }
            N++;
        }

    }

    static boolean isPalindrome(int x) {
        String tmp = String.valueOf(x);
        String reverse = new StringBuilder(tmp).reverse().toString();
        return tmp.equals(reverse);
    }

    static boolean isPrime(int N) {
        for (int i=2; i<= Math.sqrt(N); i++ ) {
            if (N%i ==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // int range:  -2147483648～2147483647

        int testData2 = 10000009;
        int testData1  = 12321;
        int testData  = 2122212;
        int result = primePalindrome(testData);

        System.out.printf(" input %d primePalindrome is: %s ", testData, result);
    }


}
