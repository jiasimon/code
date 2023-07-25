package com.sjia.Leetcode;

public class UglyNumber {

    // #263. Ugly Number https://leetcode.com/problems/ugly-number/

    /*
        Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
        1 is typically treated as an ugly number.

     */


    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Ugly Number.
    //Memory Usage: 36.8 MB, less than 27.19% of Java online submissions for Ugly Number.

    // 1ms, 100.00%; 39.69mb, 67.18%
    public boolean isUgly2(int num) {
        if (num <= 0) return false;
        while (true) {
            int tmp = num;
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else if (num == 1) return true;
            else if (num == tmp) return false;
        }
    }


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Ugly Number.
    //Memory Usage: 36.9 MB, less than 5.26% of Java online submissions for Ugly Number.
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }


    public static void main(String[] args) {
        int num = 14;
        UglyNumber solution = new UglyNumber();
        boolean result = solution.isUgly(num);
        System.out.println(num + " is an Ugly Number: " + result); // Output: 14 is an Ugly Number: false
    }


}


