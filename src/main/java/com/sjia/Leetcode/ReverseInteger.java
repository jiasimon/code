package com.sjia.Leetcode;

import static java.lang.StrictMath.abs;

public class ReverseInteger {

/*    static int reverse(int x) {
        int result = 0;
//        int lengh = String.valueOf(abs(x)).length();
//        for (int i=0; i<lengh; i++) {
        while (x !=0) {
            if  ( abs(result) > Integer.MAX_VALUE/ 10 ) {
                System.out.println("reversed integer is out of Int range: ");
                return 0;
            }
            result = result * 10 + x%10;
            x = x/10;
        }
        return result;

    }*/

    static int reverse(int x) {
        if (x==Integer.MIN_VALUE) return 0;
        Long result = 0L;
        int flag = x>0 ? 1: -1;

        String tmp = String.valueOf( Math.abs(x));
        String reverse = new StringBuilder(tmp).reverse().toString();
        result = Long.valueOf(reverse) * flag;
        if (result>=Integer.MIN_VALUE && result<=Integer.MAX_VALUE) {
            return result.intValue();
        }
        else  return 0;

    }




    public static void main(String[] args) {
        // int range:  -2147483648～2147483647

        // int testData = -2147483648
        int testData2 = 1000000009;
        int testData1  = -12674;
        int testData  = -2147483648;
        int result = reverse(testData);

        System.out.println("reversed integer is: " + result);
    }


}
