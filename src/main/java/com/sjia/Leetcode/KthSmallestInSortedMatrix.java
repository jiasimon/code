package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    // #378. Kth Smallest Element in a Sorted Matrix    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    // compare to #373

    /*
    Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

    Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    You must find a solution with a memory complexity better than O(n2).
    Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8  Output: 13

    n == matrix.length == matrix[i].length
    1 <= n <= 300
    -10^9 <= matrix[i][j] <= 10^9
    All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.

   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]

     */


    // brute force, to 1-D array
    // 13ms, 63.18%; 47.1 MB, 57.79%
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] tmp = new int[m*n];

        int index =0;
        for ( int[] row : matrix ) {
            for (int num: row) {
                tmp[index] = num;
                index++;
            }
        }
        Arrays.sort(tmp);

        return tmp[k-1];

    }


    // PriorityQueue, maxHeap
    // 16 ms, 59.35%; 45.8 MB,85.18%
    public int kthSmallest_MaxHeap(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for ( int[] row : matrix ) {
            for (int num: row) {
                maxHeap.offer(num);
                if (maxHeap.size() > k ) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.poll();

    }



    // Min Heap to find kth smallest element from N sorted list
    // 18 ms, 52.32%; 45.5 MB, 94.35%
    public int kthSmallest_minHeap(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = -1;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a,b) -> a[0] - b[0] );

        for (int r = 0; r < Math.min(m, k); ++r) {
            minHeap.offer(new int[]{matrix[r][0], r, 0});
        }

        for (int i = 1; i <= k; ++i) {
            int[] top = minHeap.poll();
            int r = top[1], c = top[2]; // r: row; c: column
            res = top[0];
            if (c + 1 < n) minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
        }

        return res;
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
