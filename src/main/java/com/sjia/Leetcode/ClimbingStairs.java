package com.sjia.Leetcode;

public class ClimbingStairs {

    // #70. Climbing Stairs  Climbing Stairs https://leetcode.com/problems/climbing-stairs/

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


    // DP, dp = new int[n+1]
    static int climbStairs(int n) {
        if (n < 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    public static void main(String[] args) {

        //testData  = 10 :89, 6 :13
        int testData  = 6;
        int result = climbStairs(testData);

        System.out.printf(" testData %s  fibo is %s \n", testData,result);

        int n1 = 2;
        System.out.println("Number of distinct ways to climb " + n1 + " stairs: " + climbStairs(n1)); // Output: 2

        int n2 = 3;
        System.out.println("Number of distinct ways to climb " + n2 + " stairs: " + climbStairs(n2)); // Output: 3

    }

}
