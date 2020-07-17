package com.sjia.Leetcode;

public class PalindromeSuper {

    // #906 https://leetcode.com/problems/super-palindromes/

    // a positive integer is a superpalindrome if it is a palindrome, and it is also the square of a palindrome.
    // Now, given two positive integers L and R (represented as strings),
    // return the number of superpalindromes in the inclusive range [L, R].

    // 1 <= len(L) <= 18
    //1 <= len(R) <= 18
    //L and R are strings representing integers in the range [1, 10^18).
    //int(L) <= int(R)

    // "38455498359" ,"999999999999999999" output: 23 , expected: 45

    // Runtime: 193 ms, faster than 65.05% of Java online submissions for Super Palindromes.
    //Memory Usage: 39.8 MB, less than 61.54% of Java online submissions for Super Palindromes.

    static int superpalindromesInRange(String L, String R) {
        long lo = Long.valueOf(L);
        long hi = Long.valueOf(R);
        int range = 100000;
        int result = 0;

        for (int i=1; i < range; i++) {
            StringBuilder sb = new StringBuilder( String.valueOf(i));
            for (int j = sb.length() - 2; j>=0; j--) {
                sb.append(sb.charAt(j));
            }
            long tmp = Long.valueOf(sb.toString());
            tmp *= tmp;
            if ( tmp > hi) break;
            if ( tmp >= lo && isPalindrome(tmp))  result++;
        }


        for (int i=1; i < range; i++) {
            StringBuilder sb = new StringBuilder( String.valueOf(i));
            for (int j = sb.length() - 1; j>=0; j--) {
                sb.append(sb.charAt(j));
            }
            //long tmp = Long.valueOf(sb);
            long tmp = Long.valueOf(sb.toString());
            tmp *= tmp;
            if ( tmp > hi) break;
            if ( tmp >= lo && isPalindrome(tmp))  result++;
        }
        return result;
    }

    static boolean isPalindrome(long x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        long revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;

    }


    public static void main(String[] args) {
        // int range:  -2147483648～2147483647

        String sL = "38455498359";
        String sR = "999999999999999999";
        int result = superpalindromesInRange(sL, sR);

        System.out.printf(" input %s , %s primePalindrome is: %s ", sL, sR, result);
    }




}
