package com.sjia.Leetcode;

public class LargestTriangleArea {
    // #812 https://leetcode.com/problems/largest-triangle-area/

    // 计算任意多边形的面积
    // Runtime: 4 ms, faster than 87.37% of Java online submissions for Largest Triangle Area.
    //Memory Usage: 37.3 MB, less than 78.84% of Java online submissions for Largest Triangle Area.
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res=0;
        for (int i=0; i<n-2; i++)
            for(int j=i+1; j<n-1; j++)
                for(int k=j+1; k<n; k++) {
                    res= Math.max(res, getArea(points[i], points[j], points[k] ) );
                }
        return res;
    }

    private double getArea(int[] A, int[] B, int[] C) {
        return 0.5 * Math.abs(A[0]*B[1] + B[0] * C[1] + C[0] * A[1] -
                A[1] * B[0] - B[1] * C[0] - C[1] * A[0]);
    }


}
