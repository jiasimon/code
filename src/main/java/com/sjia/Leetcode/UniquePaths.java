package com.sjia.Leetcode;

public class UniquePaths {
    //  #62. Unique Paths   https://leetcode.com/problems/unique-paths/
    /*
    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

    Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

    The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
     */

    // Input: m = 3, n = 7  Output: 28
    // 1 <= m, n <= 100




    // math, (m-1 + n-1)!  / (m-1)!(n-1)!
    public static int uniquePaths(int m, int n) {
        long res = 1;  // int might out of range
        for (int i= m+n-2, j=1; i >=Math.max(m,n); i--, j++ ) {
            res = res * i /j;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int uniquePaths = uniquePaths(m, n);
        System.out.println("Number of unique paths: " + uniquePaths); // Output: 28
    }


}
