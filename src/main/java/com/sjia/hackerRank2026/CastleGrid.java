package com.sjia.hackerRank2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CastleGrid {
    // https://www.hackerrank.com/challenges/castle-on-the-grid/problem

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        // Edge case: already at the goal
        if (startX == goalX && startY == goalY) {
            return 0;
        }

        int n = grid.size();
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        // Format in queue: {row, col, moves}
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        // Direction arrays for navigating Up, Down, Left, Right
        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];
            int currMoves = current[2];

            // Explore all 4 straight directions
            for (int i = 0; i < 4; i++) {
                int nextX = currX;
                int nextY = currY;

                // Continue sliding in the current direction until an obstacle or wall is hit
                while (true) {
                    nextX += rowOffsets[i];
                    nextY += colOffsets[i];

                    // Check boundaries and check if the cell is blocked ('X')
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || grid.get(nextX).charAt(nextY) == 'X') {
                        break;
                    }

                    // Check if we reached our target destination
                    if (nextX == goalX && nextY == goalY) {
                        return currMoves + 1;
                    }

                    // If it's a valid unvisited spot, mark it and add to queue
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY, currMoves + 1});
                    }
                }
            }
        }

        return -1; // Return -1 if the goal is unreachable
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid.add(bufferedReader.readLine());
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int startX = Integer.parseInt(firstMultipleInput[0]);
        int startY = Integer.parseInt(firstMultipleInput[1]);
        int goalX = Integer.parseInt(firstMultipleInput[2]);
        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);

        bufferedReader.close();
    }

}
