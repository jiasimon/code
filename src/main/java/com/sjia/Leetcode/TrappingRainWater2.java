package com.sjia.Leetcode;

import java.util.PriorityQueue;

public class TrappingRainWater2 {
    // #407. Trapping Rain Water II     https://leetcode.com/problems/trapping-rain-water-ii/

    /*
    Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

    Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
    Output: 4
    Explanation: After the rain, water is trapped between the blocks. We have two small ponds 1 and 3 units trapped.
    The total volume of water trapped is 4.

    Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
    Output: 10

    1 <= m, n <= 200
    0 <= heightMap[i][j] <= 2 * 10000
     */


    // PriorityQueue  , revisit
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int rows = heightMap.length;
        int cols = heightMap[0].length;
        int trappedWater = 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add the outer boundary cells to the priority queue
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            pq.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
            visited[i][cols - 1] = true;
        }
        for (int j = 1; j < cols - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
            pq.offer(new Cell(rows - 1, j, heightMap[rows - 1][j]));
            visited[rows - 1][j] = true;
        }

        // Define the four directions to move (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Process cells in the priority queue
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] direction : directions) {
                int newRow = cell.row + direction[0];
                int newCol = cell.col + direction[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    trappedWater += Math.max(0, cell.height - heightMap[newRow][newCol]);
                    pq.offer(new Cell(newRow, newCol, Math.max(heightMap[newRow][newCol], cell.height)));
                    visited[newRow][newCol] = true;
                }
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        TrappingRainWater2 solution = new TrappingRainWater2();
        int[][] heightMap = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        int trappedWater = solution.trapRainWater(heightMap);
        System.out.println("Trapped water: " + trappedWater);
    }


    class Cell {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

}
