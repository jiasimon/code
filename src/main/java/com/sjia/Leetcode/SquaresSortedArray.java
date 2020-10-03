package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class SquaresSortedArray {
    // #977 https://leetcode.com/problems/squares-of-a-sorted-array/
    // Input: [-4,-1,0,3,10]   Output: [0,1,9,16,100]
    // Input: [-7,-3,2,3,11]   Output: [4,9,9,49,121]

    // 1 <= A.length <= 10000
    // -10000 <= A[i] <= 10000
    // A is sorted in non-decreasing order.

    // Missed this condition: Given an array of integers A sorted in non-decreasing order

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



    // Runtime: 2 ms, faster than 71.02% of Java online submissions for Squares of a Sorted Array.
    //Memory Usage: 41.3 MB, less than 45.86% of Java online submissions for Squares of a Sorted Array.
/*    public int[] sortedSquares(int[] A) {
        for (int i =0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }*/


    // Stream
    // Runtime: 9 ms, faster than 13.59% of Java online submissions for Squares of a Sorted Array.
    // Memory Usage: 54.4 MB, less than 5.00% of Java online submissions for Squares of a Sorted Array.
/*    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map( x -> x*x).sorted().toArray();
    }*/


    // two pointer for already sorted input
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
    // Memory Usage: 41.2 MB, less than 56.12% of Java online submissions for Squares of a Sorted Array.
/*
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int i=0, j=n-1;
        for (int k = n-1; k>=0; k--) {
            if (A[i]<0 && A[i] + A[j] <=0) {
                res[k] =A[i] * A[i];
                i++;
            } else {
                res[k] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
*/



}
