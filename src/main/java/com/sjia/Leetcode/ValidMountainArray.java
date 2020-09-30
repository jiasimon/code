package com.sjia.Leetcode;

public class ValidMountainArray {
    // #941 https://leetcode.com/problems/valid-mountain-array/
    // A.length >= 3
    // There exists some i with 0 < i < A.length - 1 such that:
    // A[0] < A[1] < ... A[i-1] < A[i]
    // A[i] > A[i+1] > ... > A[A.length - 1]


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Mountain Array.
    //Memory Usage: 40.2 MB, less than 74.82% of Java online submissions for Valid Mountain Array.
    public boolean validMountainArray(int[] A) {
        int N=A.length, i=0, j=N-1;
        while (i < N-1 && A[i]< A[i+1]) i++;
        while (j>0 && A[j] < A[j-1]) j--;
        return i > 0 && j<N-1 && i==j;
    }



}
