package com.sjia.Leetcode;

public class IslandPerimeter463 {
    // #463. Island Perimeter   https://leetcode.com/problems/island-perimeter/

    /*
    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]     Output: 16

    Input: grid = [[1]]     Output: 4
    Input: grid = [[1,0]]   Output: 4

    1 <= row, col <= 100
    grid[i][j] is 0 or 1.
    There is exactly one island in grid.
     */

    // check adj, [i - 1][j], [i + 1][j], [i][j - 1], [i][j + 1]
    // 4 ms, 99.90%; 44.5 MB, 13.16%
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // For each land cell, count its perimeter contribution
                    perimeter += 4; // Start with the assumption of a full square
                    // Check adjacent cells (up, down, left, right) and subtract 1 for each neighboring land cell
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter--;
                    }
                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        perimeter--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter--;
                    }
                    if (j < cols - 1 && grid[i][j + 1] == 1) {
                        perimeter--;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter463 solution = new IslandPerimeter463();
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        int perimeter = solution.islandPerimeter(grid);
        System.out.println("Island Perimeter: " + perimeter); // Output: 16
    }

}
