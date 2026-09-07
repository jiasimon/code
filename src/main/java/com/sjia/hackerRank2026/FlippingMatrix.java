package com.sjia.hackerRank2026;

import java.util.List;

public class FlippingMatrix {
    // https://www.hackerrank.com/challenges/flipping-the-matrix/problem

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size();
        int res = 0;

        // note: loop is only n/2
        for (int i=0; i< n/2; i++) {
            for (int j=0; j < n/2 ; j++) {
                int v1 = matrix.get(i).get(j);
                int v2 = matrix.get(i).get(n-1-j);
                int v3 = matrix.get(n-1-i).get(j);
                int v4 = matrix.get(n-1-i).get(n-1-j);
                res += Math.max(Math.max(v1,v2), Math.max(v3,v4));
            }
        }
        return res;
    }
}
