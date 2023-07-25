package com.sjia.Leetcode;

public class UglyNumber2 {
    // #264. Ugly Number II     https://leetcode.com/problems/ugly-number-ii/
    /*
    Given an integer n, return the nth ugly number.
    Input: n = 10   Output: 12
    [1, 2, 3, 4, 5, 6, 8, 9, 10, 12]

    1 <= n <= 1690
     */


    // TLE ,  failed on n=1352
    public int nthUglyNumber(int n) {
        int count=0, res;
        for (int i=1; i< Integer.MAX_VALUE; i++) {
            if(isUgly(i)) {
                count++;
                if (count == n) return i;
            }

        }
        return -1;
    }

    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

    public static void main(String[] args) {
        int n = 10;
        UglyNumber2 solution = new UglyNumber2();
        int result = solution.nthUglyNumber(n);
        System.out.println("The " + n + "th Ugly Number is: " + result); // Output: The 10th Ugly Number is: 12
        // n = 20; res = 36

    }


}
