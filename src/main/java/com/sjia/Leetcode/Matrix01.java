package com.sjia.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    // #542. 01 Matrix  https://leetcode.com/problems/01-matrix/description/
    /*
    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

    The distance between two adjacent cells is 1.

    Input: mat = [[0,0,0],[0,1,0],[0,0,0]]      Output: [[0,0,0],[0,1,0],[0,0,0]]
    Input: mat = [[0,0,0],[0,1,0],[1,1,1]]      Output: [[0,0,0],[0,1,0],[1,2,1]]
    1 <= m, n <= 10000
    1 <= m * n <= 10000
     */

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();

        // Add all 0s to the queue and mark others as -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] == -1) {
                        matrix[nx][ny] = distance;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Matrix01 solution = new Matrix01();

        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        int[][] updatedMatrix = solution.updateMatrix(matrix);
        System.out.println("Updated Matrix:");
        solution.printMatrix(updatedMatrix);
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


}
