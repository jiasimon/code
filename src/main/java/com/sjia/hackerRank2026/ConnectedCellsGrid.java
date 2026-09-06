package com.sjia.hackerRank2026;

import java.util.List;

public class ConnectedCellsGrid {
    // https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem

    public static int connectedCell(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int res = 0;

        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if(matrix.get(r).get(c) == 1) {
                    int currentRegionSize = getRegionSize(matrix, r, c, rows, cols);
                    res = Math.max(res, currentRegionSize);
                }
            }
        }
        return res;
    }

    private static int getRegionSize(List<List<Integer>> matrix, int r, int c, int rows, int cols) {
        // Boundary check and condition check
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix.get(r).get(c) == 0) {
            return 0;
        }
        // Mark current cell as visited by setting it to 0
        matrix.get(r).set(c, 0);
        int size = 1;

        // Explore all 8 adjacent directions (horizontal, vertical, diagonal)
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr != 0 || dc != 0) {
                    size += getRegionSize(matrix, r + dr, c + dc, rows, cols);
                }
            }
        }
        return size;
    }

}
