package com.sjia.Leetcode;

public class KthSmallestInSortedMatrix {
    // #378. Kth Smallest Element in a Sorted Matrix    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

    /*
    Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

    Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    You must find a solution with a memory complexity better than O(n2).
    Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8  Output: 13

    n == matrix.length == matrix[i].length
    1 <= n <= 300
    -10^9 <= matrix[i][j] <= 10^9
    All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
     */


    public int kthSmallest(int[][] matrix, int k) {


        return -1;
    }


    public static void main(String[] args) {
        KthSmallestInSortedMatrix solution = new KthSmallestInSortedMatrix();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int kthSmallest = solution.kthSmallest(matrix, k);
        System.out.println("Kth Smallest Element: " + kthSmallest); // Output: 13
    }

}
