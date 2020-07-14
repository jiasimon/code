package com.sjia.Leetcode;

import static java.lang.StrictMath.abs;

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






    // #9 https://leetcode.com/problems/palindrome-number/
    // Runtime: 20 ms, faster than 9.53% of Java online submissions for Palindrome Number.
    //Memory Usage: 38.9 MB, less than 54.92% of Java online submissions for Palindrome Number.

    static boolean isPalindrome(int x) {
        if ( x < 0 || ( (x%10)==0 && x!=0)) return  false;
        String tmp = String.valueOf(x);
        StringBuilder output = new StringBuilder(tmp).reverse();
        if ( tmp.equals(output.toString())) return true;
        else return false;
    }


    //Input: -121
    //Output: false

    public static void main(String[] args) {
        // int range:  -2147483648～2147483647

        int testData2 = 1000000009;
        int testData1  = 12321;
        int testData  = 212;
        boolean result = isPalindrome(testData);

        System.out.printf(" input %d isPalindrome: %b ", testData, result);
    }

}
