package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow417 {
    // #417. Pacific Atlantic Water Flow    https://leetcode.com/problems/pacific-atlantic-water-flow/

    /*
    There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

    Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the “Pacific ocean” touches the left and top edges of the matrix and the “Atlantic ocean” touches the right and bottom edges.

    Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

    Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

      Pacific ~   ~   ~   ~   ~
           ~  1   2   2   3  (5) *
           ~  3   2   3  (4) (4) *
           ~  2   4  (5)  3   1  *
           ~ (6) (7)  1   4   5  *
           ~ (5)  1   1   2   4  *
              *   *   *   *   * Atlantic
    Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
    Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
    Explanation: The following cells can flow to the Pacific and Atlantic oceans,

     */


    //
    // 4 ms, 98.25%; 45.2 MB, 15.57%
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Create boolean matrices to mark whether water can flow to the Pacific and Atlantic
        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        // Start DFS from the borders to mark reachable cells for both oceans
        for (int i = 0; i < m; i++) {
            dfs(matrix, canReachPacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, canReachAtlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, canReachPacific, 0, j, Integer.MIN_VALUE);
            dfs(matrix, canReachAtlantic, m - 1, j, Integer.MIN_VALUE);
        }

        // Find cells that can flow to both Pacific and Atlantic
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }


    // 4 ms, 98.30%; 45 MB, 35.32%
    /*
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);


                res.add(Arrays.asList(i,j));
     */



    private void dfs(int[][] matrix, boolean[][] canReach, int i, int j, int prevHeight) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || canReach[i][j] || matrix[i][j] < prevHeight) {
            return;
        }

        canReach[i][j] = true;

        // Explore adjacent cells
        dfs(matrix, canReach, i + 1, j, matrix[i][j]);
        dfs(matrix, canReach, i - 1, j, matrix[i][j]);
        dfs(matrix, canReach, i, j + 1, matrix[i][j]);
        dfs(matrix, canReach, i, j - 1, matrix[i][j]);
    }






}
