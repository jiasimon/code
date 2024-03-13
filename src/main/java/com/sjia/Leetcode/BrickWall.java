package com.sjia.Leetcode;

import java.util.*;

public class BrickWall {
    // #554. Brick Wall     https://leetcode.com/problems/brick-wall/description/
    /*
    Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall,

    Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.

    Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]   Output: 2

    Input: wall = [[1],[1],[1]]     Output: 3
     */

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCounts = new HashMap<>();

        for (List<Integer> row : wall) {
            int edge = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                edge += row.get(i);
                edgeCounts.put(edge, edgeCounts.getOrDefault(edge, 0) + 1);
            }
        }

        int maxEdges = 0;
        for (int count : edgeCounts.values()) {
            maxEdges = Math.max(maxEdges, count);
        }

        return wall.size() - maxEdges;

    }

    public static void main(String[] args) {
        BrickWall solution = new BrickWall();

        List<List<Integer>> testWall = new ArrayList<>();
        testWall.add(Arrays.asList(1, 2, 2, 1));
        testWall.add(Arrays.asList(3, 1, 2));
        testWall.add(Arrays.asList(1, 3, 2));
        testWall.add(Arrays.asList(2, 4));
        testWall.add(Arrays.asList(3, 1, 2));
        testWall.add(Arrays.asList(1, 3, 1, 1));

        System.out.println("Test Case 1: " + solution.leastBricks(testWall)); // Output: 2
    }
}
