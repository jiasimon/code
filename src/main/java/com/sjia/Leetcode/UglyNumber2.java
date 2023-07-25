package com.sjia.Leetcode;

public class UglyNumber2 {
    // #264. Ugly Number II     https://leetcode.com/problems/ugly-number-ii/
    /*
    Given an integer n, return the nth ugly number.
    Input: n = 10   Output: 12
    [1, 2, 3, 4, 5, 6, 8, 9, 10, 12]

    1 <= n <= 1690
     */



    // three pointer p2, p3, p5, use if instead of else if
    // 3ms, 70.84%; 40.66mb, 62.83%
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(uglyNumbers[p2] * 2, Math.min(uglyNumbers[p3] * 3, uglyNumbers[p5] * 5));
            uglyNumbers[i] = nextUgly;

            if (nextUgly == uglyNumbers[p2] * 2) {
                p2++;
            }
            if (nextUgly == uglyNumbers[p3] * 3) {
                p3++;
            }
            if (nextUgly == uglyNumbers[p5] * 5) {
                p5++;
            }
        }

        return uglyNumbers[n - 1];
    }




    // TLE ,  failed on n=1352
    public int nthUglyNumberCheckUgly(int n) {
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
