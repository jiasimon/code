package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort1631 {
    // #1631. Path With Minimum Effort      https://leetcode.com/problems/path-with-minimum-effort/description/?envType=daily-question&envId=2023-09-16

    /*
    You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

    A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

    Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

    Input: heights = [[1,2,2],[3,8,2],[5,3,5]]      Output: 2

    Input: heights = [[1,2,3],[3,8,4],[5,3,5]]      Output: 1

    1 <= rows, columns <= 100
    1 <= heights[i][j] <= 10^6

     */


    class Cell {
        int row;
        int col;
        int effort;

        public Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    // use Dijkstra's algorithm. In this algorithm, you start from the source cell and explore adjacent cells with minimum effort,
    // keeping track of the minimum effort required to reach each cell.
    // 43 ms, 65.93%; 44.5 MB, 31.33%
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up

        // Initialize the minimum effort array with maximum values
        int[][] minEffort = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(minEffort[i], Integer.MAX_VALUE);
        }

        // Priority queue to select the cell with the minimum effort
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        queue.offer(new Cell(0, 0, 0));

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // If we reached the destination cell, return the minimum effort
            if (current.row == rows - 1 && current.col == cols - 1) {
                return current.effort;
            }

            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(current.effort, Math.abs(heights[newRow][newCol] - heights[current.row][current.col]));
                    if (newEffort < minEffort[newRow][newCol]) {
                        minEffort[newRow][newCol] = newEffort;
                        queue.offer(new Cell(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return 0; // Unreachable if the queue is empty

    }



    public static void main(String[] args) {
        PathWithMinimumEffort1631 solution = new PathWithMinimumEffort1631();
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int minEffort = solution.minimumEffortPath(heights);
        System.out.println("Minimum Effort: " + minEffort); // Output: 2
    }
}
