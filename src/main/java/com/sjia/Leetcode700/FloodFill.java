package com.sjia.Leetcode700;

public class FloodFill {
    // #733. Flood Fill     https://leetcode.com/problems/flood-fill/description/
    /*

     */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        // If the original color is the same as the new color, no changes are needed
        if (originalColor != newColor) {
            dfs(image, sr, sc, originalColor, newColor);
        }

        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Check for out-of-bounds conditions or if the color does not match
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }

        // Change the color of the current pixel
        image[r][c] = newColor;

        // Explore all four directions
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r, c + 1, originalColor, newColor); // Right
        dfs(image, r, c - 1, originalColor, newColor); // Left
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();

        // Test Case 1
        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result1 = solution.floodFill(image1, 1, 1, 2);
        printImage(result1); // Expected: [[2, 2, 2], [2, 2, 0], [2, 0, 1]]

        // Test Case 2
        int[][] image2 = {{0, 0, 0}, {0, 1, 1}};
        int[][] result2 = solution.floodFill(image2, 1, 1, 1);
        printImage(result2); // Expected: [[0, 0, 0], [0, 1, 1]]

        // Test Case 3
        int[][] image3 = {{0}};
        int[][] result3 = solution.floodFill(image3, 0, 0, 1);
        printImage(result3); // Expected: [[1]]
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
