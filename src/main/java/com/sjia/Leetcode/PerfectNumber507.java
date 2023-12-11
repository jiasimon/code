package com.sjia.Leetcode;

public class PerfectNumber507 {
    // #507. Perfect Number     https://leetcode.com/problems/perfect-number/

    /*
    A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

    Given an integer n, return true if n is a perfect number, otherwise return false.

    Input: num = 28     Output: true
    Input: num = 7      Output: false
    1 <= num <= 10^8
     */

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1; // 1 is a divisor for every number

        // Check for divisors up to sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        PerfectNumber507 solution = new PerfectNumber507();

        int num = 28;

        boolean isPerfect = solution.checkPerfectNumber(num);
        if (isPerfect) {
            System.out.println(num + " is a perfect number.");
        } else {
            System.out.println(num + " is not a perfect number.");
        }
    }
}
