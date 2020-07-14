package com.sjia.Leetcode;

import static java.lang.StrictMath.abs;

public class PalindromeNumber {


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


/*    static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        return reverse(x) == x;
    }

    static int reverse(int x) {
        int result = 0;
        while (x !=0) {
            if  ( abs(result) > Integer.MAX_VALUE/ 10 ) {
                System.out.println("reversed integer is out of Int range: ");
                return -1;
            }
            result = result * 10 + x%10;
            x = x/10;
        }
        return result;
    }*/

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
