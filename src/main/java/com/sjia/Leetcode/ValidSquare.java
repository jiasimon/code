package com.sjia.Leetcode;

import java.util.Arrays;

public class ValidSquare {
    // #593. Valid Square   https://leetcode.com/problems/valid-square/description/
    /*
    Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

    The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

    A valid square has four equal sides with positive length and four equal angles (90-degree angles).

    p1.length == p2.length == p3.length == p4.length == 2
    -10000 <= xi, yi <= 10000
     */

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = {p1, p2, p3, p4};

        // Calculate distances between each pair of points
        int[] distances = new int[6];
        int k = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distances[k++] = distance(points[i], points[j]);
            }
        }

        // Sort distances to find the side length and diagonal length
        Arrays.sort(distances);

        // If the square is valid, the side length will be equal to the smallest four distances
        // and the diagonal length will be equal to the largest two distances
        return distances[0] == distances[1] && distances[1] == distances[2] &&
                distances[2] == distances[3] && distances[4] == distances[5] &&
                distances[4] > distances[0];
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) +
                (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        ValidSquare solution = new ValidSquare();

        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};

        System.out.println("Test Case 1: " + solution.validSquare(p1, p2, p3, p4)); // Output: true
    }

}
