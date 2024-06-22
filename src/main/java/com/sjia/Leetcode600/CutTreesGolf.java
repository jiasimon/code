package com.sjia.Leetcode600;

import java.util.*;

public class CutTreesGolf {
    // #675. Cut Off Trees for Golf Event   https://leetcode.com/problems/cut-off-trees-for-golf-event/description/
    /*
    You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:

    0 means the cell cannot be walked through.
    1 represents an empty cell that can be walked through.
    A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.

    Note: The input is generated such that no two trees have the same height, and there is at least one tree needs to be cut off.
     */

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }

        trees.sort((a, b) -> Integer.compare(a[0], b[0]));

        int totalSteps = 0;
        int startX = 0, startY = 0;

        for (int[] tree : trees) {
            int steps = bfs(forest, startX, startY, tree[1], tree[2]);
            if (steps == -1) {
                return -1;
            }
            totalSteps += steps;
            startX = tree[1];
            startY = tree[2];
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int startX, int startY, int targetX, int targetY) {
        int m = forest.size(), n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                if (x == targetX && y == targetY) {
                    return steps;
                }
                for (int[] dir : DIRECTIONS) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && forest.get(newX).get(newY) != 0) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }


    public static void main(String[] args) {
        CutTreesGolf solution = new CutTreesGolf();

        // Test case 1
        List<List<Integer>> forest1 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(0, 0, 4),
                Arrays.asList(7, 6, 5)
        );
        System.out.println("Test case 1: " + solution.cutOffTree(forest1)); // Expected output: 6

        // Test case 2
        List<List<Integer>> forest2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(0, 0, 0),
                Arrays.asList(7, 6, 5)
        );
        System.out.println("Test case 2: " + solution.cutOffTree(forest2)); // Expected output: -1

        // Test case 3
        List<List<Integer>> forest3 = Arrays.asList(
                Arrays.asList(2, 3, 4),
                Arrays.asList(0, 0, 5),
                Arrays.asList(8, 7, 6)
        );
        System.out.println("Test case 3: " + solution.cutOffTree(forest3)); // Expected output: 6

        // Test case 4
        List<List<Integer>> forest4 = Arrays.asList(
                Arrays.asList(1)
        );
        System.out.println("Test case 4: " + solution.cutOffTree(forest4)); // Expected output: 0

        // Test case 5
        List<List<Integer>> forest5 = Arrays.asList(
                Arrays.asList(4, 2, 3),
                Arrays.asList(0, 0, 1),
                Arrays.asList(7, 6, 5)
        );
        System.out.println("Test case 5: " + solution.cutOffTree(forest5)); // Expected output: 10
    }

}
