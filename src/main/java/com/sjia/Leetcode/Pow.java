package com.sjia.Leetcode;

public class Pow {
    // #50. Pow(x, n)  https://leetcode.com/problems/powx-n/

    /*
    // Input: x = 2.00000, n = 10 Output: 1024.00000
        Input: x = 2.10000, n = 3  Output: 9.26100
    // Input: x = 2.00000, n = -2 Output: 0.25000  Explanation: 2-2 = 1/22 = 1/4 = 0.25
     */

    // -100.0 < x < 100.0, -2^31 <= n <= 2^31-1 , n is an integer.Either x is not zero or n > 0
    // -10^4 <= x^n <= 10^4

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            x = 1 / x;  // check condition if x can be 0
            n = -n;
        }

        return slowPow(x, n);
    }

    private static double slowPow(double x, int n) {
        double res =1;
        while (n > 0) {
            res *= x;
            n--;
        }
        return res;
    }


    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println("Power: " + myPow(x, n)); // Output: 1024.0

        double x2 = 2.1;
        int n2 = 3;
        System.out.println("Power: " + myPow(x2, n2)); // Output: 9.261

        double x3 = 2.0;
        int n3 = -2;
        System.out.println("Power: " + myPow(x3, n3)); // Output: 0.25
    }


}
