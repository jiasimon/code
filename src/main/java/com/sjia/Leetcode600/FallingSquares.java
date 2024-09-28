package com.sjia.Leetcode600;

import java.util.ArrayList;
import java.util.List;

public class FallingSquares {
    // #699. Falling Squares    https://leetcode.com/problems/falling-squares/description/
    /*

     */


    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> intervals = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int currentMaxHeight = 0;

        for (int[] position : positions) {
            int left = position[0];
            int sideLength = position[1];
            int right = left + sideLength;
            int baseHeight = 0;

            // Find the maximum height of intersecting intervals
            for (int[] interval : intervals) {
                int l = interval[0];
                int r = interval[1];
                int h = interval[2];

                if (left < r && right > l) { // If the current square intersects with an existing interval
                    baseHeight = Math.max(baseHeight, h);
                }
            }

            // The new height after dropping the current square
            int newHeight = baseHeight + sideLength;
            intervals.add(new int[]{left, right, newHeight});
            currentMaxHeight = Math.max(currentMaxHeight, newHeight);
            result.add(currentMaxHeight);
        }

        return result;
    }

    public static void main(String[] args) {
        FallingSquares solution = new FallingSquares();

        // Test case 1
        int[][] positions1 = {{1, 2}, {2, 3}, {6, 1}};
        System.out.println("Test case 1: " + solution.fallingSquares(positions1)); // Expected output: [2, 5, 5]

        // Test case 2
        int[][] positions2 = {{100, 100}, {200, 100}};
        System.out.println("Test case 2: " + solution.fallingSquares(positions2)); // Expected output: [100, 100]

        // Test case 3
        int[][] positions3 = {{1, 5}, {2, 2}, {7, 3}};
        System.out.println("Test case 3: " + solution.fallingSquares(positions3)); // Expected output: [5, 7, 7]

        // Test case 4
        int[][] positions4 = {{3, 5}, {4, 3}, {7, 4}};
        System.out.println("Test case 4: " + solution.fallingSquares(positions4)); // Expected output: [5, 8, 8]
    }



}
