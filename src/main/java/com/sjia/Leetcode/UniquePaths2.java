package com.sjia.Leetcode;

public interface UniquePaths2 {
    // #63. Unique Paths II  https://leetcode.com/problems/unique-paths-ii/
    // refer to #62  uniquePaths2
    /*
    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]  Output: 2
    Explanation: There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right

    1 <= m, n <= 100
    obstacleGrid[i][j] is 0 or 1.

     */


    // dp[m][n]  row1, line1
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Check if the start or destination cell is an obstacle
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // Create a 2D dp array to store the number of unique paths for each cell
        int[][] dp = new int[m][n];

        // Initialize the first cell with 1 since there is only one way to reach it
        dp[0][0] = 1;

        // Fill the first row and first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                // If the current cell is an obstacle, set the number of paths to 0
                dp[i][0] = 0;
            } else {
                // Otherwise, the number of paths is the same as the cell above
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                // If the current cell is an obstacle, set the number of paths to 0
                dp[0][j] = 0;
            } else {
                // Otherwise, the number of paths is the same as the cell to the left
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the rest of the dp array using dynamic programming
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // If the current cell is an obstacle, set the number of paths to 0
                    dp[i][j] = 0;
                } else {
                    // Otherwise, the number of paths is the sum of the paths from above and from the left
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int uniquePaths = uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Number of unique paths: " + uniquePaths); // Output: 2
    }






}
