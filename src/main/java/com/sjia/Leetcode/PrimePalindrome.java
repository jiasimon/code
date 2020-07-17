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


/*    static boolean isPalindrome(int x) {
        String tmp = String.valueOf(x);
        String reverse = new StringBuilder(tmp).reverse().toString();
        return tmp.equals(reverse);
    }*/



    // Runtime: 17 ms, faster than 89.25% of Java online submissions for Prime Palindrome.
    //Memory Usage: 38.2 MB, less than 59.81% of Java online submissions for Prime Palindrome.

    static boolean isPalindrome(int x) {
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }


    // add if (N%2 ==0 || N < 2) return N==2;
    //Runtime: 13 ms, faster than 89.90% of Java online submissions for Prime Palindrome.
    //Memory Usage: 36.5 MB, less than 74.77% of Java online submissions for Prime Palindrome.

    static boolean isPrime(int N) {
        if (N%2 ==0 || N < 2) return N==2;
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
