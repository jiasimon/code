package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class SqrtX {

    // #69. Sqrt(x)  https://leetcode.com/problems/sqrtx/


    // Newton
    // Runtime: 2 ms, faster than 43.15% of Java online submissions for Sqrt(x).
    //Memory Usage: 38.6 MB, less than 5.07% of Java online submissions for Sqrt(x).
    static int mySqrt2(int x) {
        if (x==0) return 0;
        long root = x;
        while (root*root > x) {
            root = (root+x/root)/2;
        }
        return (int) root;
    }


    // binary search Runtime: 2 ms, faster than 43.15% of Java online submissions for Sqrt(x).
    //Memory Usage: 39 MB, less than 5.07% of Java online submissions for Sqrt(x).
    
    static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1, right =x, result =0;
        while(left <= right) {
            int mid = left + (right-left) /2;
            if ( mid <= x/mid) {  // keep in bound, Not using mid*mid <= x
                result = mid;
                left =mid + 1;
            } else {
                right =mid - 1;
            }
        }
        return result;
    }



    public static void main(String[] args) {

        //testData  = 2147483647; 5
        int testData  = 100;
        int result = mySqrt(testData);

        System.out.printf(" testData %s mySqrt is %s \n", testData,result);

        int x1 = 4;
        System.out.println("Square root of " + x1 + " is: " + mySqrt(x1)); // Output: 2

        int x2 = 8;
        System.out.println("Square root of " + x2 + " is: " + mySqrt(x2)); // Output: 2

    }

}
