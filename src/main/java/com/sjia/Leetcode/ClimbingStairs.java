package com.sjia.Leetcode;

public class ClimbingStairs {

    // #70 Climbing Stairs https://leetcode.com/problems/climbing-stairs/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    //Memory Usage: 38 MB, less than 5.03% of Java online submissions for Climbing Stairs.
/*
    static int climbStairs(int n) {
        if (n == 1 || n==2) return n;
        int x=1, y=2, result=3;
        for (int i= 3; i<=n; i++ ) {
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }*/


    static int climbStairs(int n) {
        if (n == 1 || n==2) return n;
        int x=1, y=2, result=3;
        while ( n-- >=3) {
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }


    public static void main(String[] args) {

        //testData  = 10 :89, 6 :13
        int testData  = 6;
        int result = climbStairs(testData);

        System.out.printf(" testData %s th fibo is %s \n", testData,result);
    }

}
