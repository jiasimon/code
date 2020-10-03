package com.sjia.Leetcode;

import java.util.Arrays;

public class SquaresSortedArray {
    // #977 https://leetcode.com/problems/squares-of-a-sorted-array/
    // Input: [-4,-1,0,3,10]   Output: [0,1,9,16,100]
    // Input: [-7,-3,2,3,11]   Output: [4,9,9,49,121]

    // 1 <= A.length <= 10000
    // -10000 <= A[i] <= 10000
    // A is sorted in non-decreasing order.

    // Runtime: 4 ms, faster than 23.02% of Java online submissions for Squares of a Sorted Array.
    //Memory Usage: 54 MB, less than 5.00% of Java online submissions for Squares of a Sorted Array.
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i =0; i < A.length; i++){
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }

    

}
