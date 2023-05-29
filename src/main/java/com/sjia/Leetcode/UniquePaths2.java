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


    // dp[m][n]  row1, line1;  run result 100% 40.8MB
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




    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
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

        // Fill the first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                // If the current cell is an obstacle, set the number of paths to 0
                dp[i][0] = 0;
                break;
            } else {
                // Otherwise, the number of paths is the same as the cell above
                dp[i][0] = 1;
            }
        }

        // Fill the first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                // If the current cell is an obstacle, set the number of paths to 0
                dp[0][j] = 0;
                break;
            } else {
                // Otherwise, the number of paths is the same as the cell to the left
                dp[0][j] = 1;
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



    // recursive , refer to uniquePaths4
    // Time Limit Exceeded, TLE  30 / 41 test cases passed
    public static int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return helper(obstacleGrid,0,0,m,n);

    }

    static int helper(int[][] grid, int row, int col, int m, int n) {
        if (row == m || col == n || grid[row][col] == 1) return 0;   // grid[row][col] == 1
        if (row == m - 1 && col == n - 1) {
            if ( grid[row][col] ==1 ) return 0;
            return 1;
        }

        return helper(grid,row+1,col,m,n) + helper(grid,row,col+1,m,n);

    }



    // Memoization
    // 4ms, 11.34% , 41 MB  73.75%
    public static int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        return helperDFS(obstacleGrid,0,0,m,n, dp);

    }

    static int helperDFS(int[][] grid, int row, int col, int m, int n, int[][] dp) {
        if (row == m || col == n || grid[row][col] == 1) return 0;   // grid[row][col] == 1
        if (row == m - 1 && col == n - 1) {
            if ( grid[row][col] ==1 ) return 0;
            return 1;
        }
        if(dp[row][col] > 0) return dp[row][col]; // if calculated, direct return

        return dp[row][col]  = helperDFS(grid,row+1,col,m,n, dp) + helperDFS(grid,row,col+1,m,n, dp);

    }


    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int uniquePaths = uniquePathsWithObstacles4(obstacleGrid);
        System.out.println("Number of unique paths: " + uniquePaths); // Output: 2

        int[][] obstacleGridTwo = {
                {0, 0, 0,0,0},
                {0, 1, 0,0,0},
                {0, 0, 0,0,0}
        };

        int res = uniquePathsWithObstacles4(obstacleGridTwo);
        System.out.println("Number of unique paths: " + res); // Output: 7


    }






}
