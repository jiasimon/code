package com.sjia.Leetcode;

public class ValidPerfectSquare {
    // #367 https://leetcode.com/problems/valid-perfect-square/

    // Runtime: 1 ms, faster than 20.90% of Java online submissions for Valid Perfect Square.
    //Memory Usage: 38.8 MB, less than 5.15% of Java online submissions for Valid Perfect Square.
/*
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int i=1;
        while (num > 0) {
            num -= i;
            i +=2;
        }
        return num==0;
    }*/

    // refer #69 Newton
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
    //Memory Usage: 38.6 MB, less than 5.15% of Java online submissions for Valid Perfect Square.
    public boolean isPerfectSquare(int num) {
        long root = num;
        while (root * root > num) {
            root = (root + num / root)/2;
        }
        return root * root == num;
    }



}
