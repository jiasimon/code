package com.sjia.Leetcode;

public class NumberofIslands {
    // #200. Number of Islands  https://leetcode.com/problems/number-of-islands/description/
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
    Input: grid = [
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","0"]
    ]
    Output: 1

    Input: grid = [
      ["1","1","0","0","0"],
      ["1","1","0","0","0"],
      ["0","0","1","0","0"],
      ["0","0","0","1","1"]
    ]
    Output: 3

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
     */

    // recursive
    // refer to #130. Surrounded Regions
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i=0; i < m; i++ ) {
            for (int j=0; j < n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfsIslands(grid, i,j);
                }
            }
        }
        return count;

    }

    private void dfsIslands(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || i>=m || j < 0 || j >=n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';  // mark visited cell as 0

        // recursive visit four directions
        dfsIslands(grid, i-1,j);
        dfsIslands(grid, i+1,j);
        dfsIslands(grid, i,j-1);
        dfsIslands(grid, i,j+1);
    }



}
