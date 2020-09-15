package com.sjia.Leetcode;

public class TransposeMatrix {
    // #867 https://leetcode.com/problems/transpose-matrix/

    // Runtime: 1 ms, faster than 31.67% of Java online submissions for Transpose Matrix.
    //Memory Usage: 46 MB, less than 20.93% of Java online submissions for Transpose Matrix.
    public int[][] transpose(int[][] A) {
        int x = A.length;
        int y = A[0].length;
        int[][] res = new int[y][x];

        for (int i = 0; i < y; i++ )
            for (int j=0; j< x ; j++) {
                res[i][j] = A[j][i];
            }
        return res;
    }


}
