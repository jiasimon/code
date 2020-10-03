package com.sjia.Leetcode;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    // #976 https://leetcode.com/problems/largest-perimeter-triangle/
    // return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
    // impossible to form any triangle of non-zero area, return 0.

    // Runtime: 11 ms, faster than 10.36% of Java online submissions for Largest Perimeter Triangle.
    // Memory Usage: 52.2 MB, less than 6.61% of Java online submissions for Largest Perimeter Triangle.
    public int largestPerimeter(int[] A) {
        int res =0;
        Arrays.sort(A);
        for (int i = A.length-1; i>=2; i--){
            if (A[i-2] + A[i-1] > A[i]) {
                res =A[i-2] + A[i-1] + A[i];
                return res;
            }
        }
        return res;
    }

}
