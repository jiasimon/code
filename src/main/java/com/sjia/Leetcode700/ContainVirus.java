package com.sjia.Leetcode700;

import java.util.*;

public class ContainVirus {
    // #749. Contain Virus  https://leetcode.com/problems/contain-virus/description/
    /*

     */


    private static final int[] DIRS = {0, 1, 0, -1, 0};

    public int containVirus(int[][] isInfected) {
        int m = isInfected.length;
        int n = isInfected[0].length;
        int totalWalls = 0;

        while (true) {
            List<Set<Integer>> regions = new ArrayList<>();
            List<Set<Integer>> frontiers = new ArrayList<>();
            List<Integer> walls = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];

            // Step 1: Identify all infected regions
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        Set<Integer> region = new HashSet<>();
                        Set<Integer> frontier = new HashSet<>();
                        int[] wallCount = {0};
                        dfs(isInfected, i, j, visited, region, frontier, wallCount);
                        regions.add(region);
                        frontiers.add(frontier);
                        walls.add(wallCount[0]);
                    }
                }
            }

            if (regions.isEmpty()) break;

            // Step 2: Find the region with the largest frontier
            int maxFrontierIdx = 0;
            for (int i = 1; i < frontiers.size(); ++i) {
                if (frontiers.get(i).size() > frontiers.get(maxFrontierIdx).size()) {
                    maxFrontierIdx = i;
                }
            }

            // Step 3: Build walls around the most threatening region
            totalWalls += walls.get(maxFrontierIdx);
            for (int idx : regions.get(maxFrontierIdx)) {
                int x = idx / n;
                int y = idx % n;
                isInfected[x][y] = -1; // Mark as contained
            }

            // Step 4: Spread the virus in other regions
            for (int i = 0; i < regions.size(); ++i) {
                if (i == maxFrontierIdx) continue;
                for (int idx : frontiers.get(i)) {
                    int x = idx / n;
                    int y = idx % n;
                    isInfected[x][y] = 1; // Spread infection
                }
            }
        }

        return totalWalls;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, Set<Integer> region, Set<Integer> frontier, int[] wallCount) {
        int m = grid.length;
        int n = grid[0].length;
        visited[x][y] = true;
        region.add(x * n + y);

        for (int d = 0; d < 4; ++d) {
            int nx = x + DIRS[d];
            int ny = y + DIRS[d + 1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(grid, nx, ny, visited, region, frontier, wallCount);
                } else if (grid[nx][ny] == 0) {
                    frontier.add(nx * n + ny);
                    wallCount[0]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        ContainVirus sol = new ContainVirus();
        int[][] isInfected1 = {
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(sol.containVirus(isInfected1)); // Output: 10

        int[][] isInfected2 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println(sol.containVirus(isInfected2)); // Output: 4
    }



}
