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


    // DP
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill the first row and first column with 1 since there is only one way to reach any cell in the first row or first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the dp array using dynamic programming
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the number of unique paths to reach the bottom-right cell
        return dp[m - 1][n - 1];
    }


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
        int uniquePaths = uniquePaths2(m, n);
        System.out.println("Number of unique paths: " + uniquePaths); // Output: 28
    }


}
