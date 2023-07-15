package com.sjia.Leetcode;

import java.util.Arrays;

public class DungeonGame {
    // #174. Dungeon Game   https://leetcode.com/problems/dungeon-game/
    /*
    To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
    Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]  Output: 7
    Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.

    Input: dungeon = [[0]]  Output: 1
     */


    // dp, last row, last col, bottom up
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        // Calculate the minimum initial health needed to reach the princess from the bottom-right cell
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        // Fill the last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }

        // Fill the last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        // Fill the remaining cells starting from the bottom-right cell
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealth = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealth - dungeon[i][j]);
            }
        }

        return dp[0][0]; // Return the minimum initial health needed for the knight
    }



    // bottom up
    public int calculateMinimumHPBottomUp(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int dp[][] = new int[m][n];

        for (int i=m-1; i>=0; i--){
            for ( int j=n-1; j>=0; j--) {
                if ( i==m-1 && j==n-1) {
                    dp[i][j] = Math.max(1, 1-dungeon[i][j]);
                } else if ( i==m-1 ) {
                    dp[i][j] = Math.max(1, dp[i][j+1]-dungeon[i][j]);
                } else if ( j==n-1) {
                    dp[i][j] = Math.max(1, dp[i+1][j]-dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }



    // recursive
    public  int calculateMinimumHPRecursive(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        return helperRecursive(dungeon,0,0,dungeon.length,dungeon[0].length);

    }

    // TLE 41 / 45 testcases passed
    public  int helperRecursive(int [][] dungeon, int i, int j , int m , int n){

        // base case 1
        if (i== m || j==n) return Integer.MAX_VALUE;

        if(i == m-1 && j == n-1) {
            if (dungeon[i][j] < 0) return -dungeon[i][j] + 1;
            else return 1;
        }

        int healthPointDown = helperRecursive(dungeon,i+1,j,m,n);
        int healthPointRight = helperRecursive(dungeon,i,j+1,m,n);
        int healthPoint = Math.min(healthPointRight,healthPointDown) - dungeon[i][j]; // this will give the minimum health point to survive in (i,j)
        return healthPoint >0 ? healthPoint : 1; //if healthpoint is negative that means the cell(i,j) had positive HPs, so the minimum health needed to survive in cell(i,j) is 1
    }


    // recursive with memo
    public  int calculateMinimumHPMemo(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int [][]dp = new int[m+1][n+1];
        for (int [] d : dp) Arrays.fill(d,-1);
        return helperRecursiveMemo(dungeon,0,0,dungeon.length,dungeon[0].length, dp);
    }

    public  int helperRecursiveMemo(int [][] dungeon, int i, int j , int m , int n, int[][] dp){

        // base case 1
        if (i== m || j==n) return Integer.MAX_VALUE;

        if(i == m-1 && j == n-1) {
            if (dungeon[i][j] < 0) return -dungeon[i][j] + 1;
            else return 1;
        }
        if (dp[i][j] != -1) return dp[i][j];

        int healthPointDown = helperRecursiveMemo(dungeon,i+1,j,m,n, dp);
        int healthPointRight = helperRecursiveMemo(dungeon,i,j+1,m,n, dp);
        int healthPoint = Math.min(healthPointRight,healthPointDown) - dungeon[i][j]; // this will give the minimum health point to survive in (i,j)
        dp[i][j] =healthPoint >0 ? healthPoint : 1; //if healthpoint is negative that means the cell(i,j) had positive HPs, so the minimum health needed to survive in cell(i,j) is 1
        return dp[i][j];
    }



    public static void main(String[] args) {
        DungeonGame solution = new DungeonGame();

        // Test case
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        int minHealth = solution.calculateMinimumHPRecursive(dungeon);
        System.out.println("Minimum Initial Health: " + minHealth);  // Expected output: 7

        int[][] dungeon2 = {
                {0, 0}
        };

        int minHealth2 = solution.calculateMinimumHPMemo(dungeon2);
        System.out.println("Minimum Initial Health: " + minHealth2);  // Expected output: 1

    }
}
