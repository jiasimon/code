package com.sjia.Leetcode700;

import java.util.*;

public class LargestPlusSign {
    // #764. Largest Plus Sign https://leetcode.com/problems/largest-plus-sign/description/
    /*
    Input: n = 5, mines = [[4,2]]   Output: 2
    Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.

    Input: n = 1, mines = [[0,0]]   Output: 0
    1 <= n <= 500
    0 <= mines.length <= 5000
    0 <= x, y < n
    All the elements of mines are unique.
     */

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];

        // Initialize the grid with 1s
        for (int[] row : grid) {
            Arrays.fill(row, n);
        }

        // Mark mines as 0s
        Set<Integer> mineSet = new HashSet<>();
        for (int[] mine : mines) {
            mineSet.add(mine[0] * n + mine[1]);
        }

        // Dynamic programming in 4 directions
        for (int r = 0; r < n; r++) {
            int count = 0;
            // Left to right
            for (int c = 0; c < n; c++) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                grid[r][c] = Math.min(grid[r][c], count);
            }

            count = 0;
            // Right to left
            for (int c = n - 1; c >= 0; c--) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                grid[r][c] = Math.min(grid[r][c], count);
            }
        }

        for (int c = 0; c < n; c++) {
            int count = 0;
            // Top to bottom
            for (int r = 0; r < n; r++) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                grid[r][c] = Math.min(grid[r][c], count);
            }

            count = 0;
            // Bottom to top
            for (int r = n - 1; r >= 0; r--) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                grid[r][c] = Math.min(grid[r][c], count);
            }
        }

        // Find max value in grid
        int maxOrder = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxOrder = Math.max(maxOrder, val);
            }
        }

        return maxOrder;
    }

    public static void main(String[] args) {
        LargestPlusSign solution = new LargestPlusSign();
        int[][] mines1 = {{4, 2}};
        System.out.println(solution.orderOfLargestPlusSign(5, mines1)); // Output: 2

        int[][] mines2 = {{0, 0}};
        System.out.println(solution.orderOfLargestPlusSign(1, mines2)); // Output: 0
    }

}
