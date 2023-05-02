package com.sjia.Leetcode;

import static java.lang.StrictMath.abs;

// #9. Palindrome Number  https://leetcode.com/problems/palindrome-number/

public class PalindromeNumber {


    // Runtime: 13 ms, faster than 19.96% of Java online submissions for Palindrome Number.
    // Memory Usage: 41.6 MB, less than 11.61% of Java online submissions for Palindrome Number.

    // Runtime: 10 ms, faster than 38.56% of Java online submissions for Palindrome Number.
    // Memory Usage: 41.4 MB, less than 14.51% of Java online submissions for Palindrome Number.

/*    static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }*/




    // Runtime: 20 ms, faster than 9.53% of Java online submissions for Palindrome Number.
    //Memory Usage: 38.9 MB, less than 54.92% of Java online submissions for Palindrome Number.

    // Runtime: 13 ms, faster than 22.11% of Java online submissions for Palindrome Number.
    //Memory Usage: 38.8 MB, less than 62.17% of Java online submissions for Palindrome Number.

    static boolean isPalindrome(int x) {
        if ( x < 0 || ( (x%10)==0 && x!=0)) return  false;
        String tmp = String.valueOf(x);
        String reverse = new StringBuilder(tmp).reverse().toString();
        return tmp.equals(reverse);
    }


    // Runtime 10 ms, 54.44%;  Memory 42 MB, 59.36%

    static boolean isPalindrome2(int x) {
        if ( x < 0 || ( (x%10)==0 && x!=0)) return  false;

        String tmp = String.valueOf(x);
        int length = tmp.length();
        if ( length < 2) return true;
        for (int i=0; i< length/2 ; i++) {
            if ( tmp.charAt(i) != tmp.charAt(length-1-i)) return false;
        }
        return true;

    }


    //Input: -121
    //Output: false

    public static void main(String[] args) {
        // int range:  -2147483648～2147483647

        int testData2 = 1000000009;
        int testData1  = 12321;
        int testData  = 2122212;
        boolean result = isPalindrome(testData);

        System.out.printf(" input %d isPalindrome: %b ", testData, result);
    }

}
