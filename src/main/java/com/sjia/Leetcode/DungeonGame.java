package com.sjia.Leetcode;

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


    public static void main(String[] args) {
        DungeonGame solution = new DungeonGame();

        // Test case
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        int minHealth = solution.calculateMinimumHP(dungeon);
        System.out.println("Minimum Initial Health: " + minHealth);  // Expected output: 7
    }
}
