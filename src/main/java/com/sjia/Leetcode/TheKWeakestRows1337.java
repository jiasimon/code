package com.sjia.Leetcode;

import java.util.Arrays;

public class TheKWeakestRows1337 {
    // #1337. The K Weakest Rows in a Matrix    https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix

    /*
    You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

    A row i is weaker than a row j if one of the following is true:

    The number of soldiers in row i is less than the number of soldiers in row j.
    Both rows have the same number of soldiers and i < j.
    Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

    Input: mat =
    [[1,1,0,0,0],
     [1,1,1,1,0],
     [1,0,0,0,0],
     [1,1,0,0,0],
     [1,1,1,1,1]],
    k = 3
    Output: [2,0,3]

    m == mat.length
    n == mat[i].length
    2 <= n, m <= 100
    1 <= k <= m


     */

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length; // Number of rows
        int n = mat[0].length; // Number of columns

        // Create an array of pairs to store the row index and sum
        Pair[] pairs = new Pair[m];

        // Calculate and store the row sums along with row indices
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mat[i][j];
            }
            pairs[i] = new Pair(i, sum);
        }

        // Sort the pairs based on sum and row index
        Arrays.sort(pairs, (a, b) -> {
            if (a.sum == b.sum) {
                return a.row - b.row; // Use row index as a tiebreaker
            }
            return a.sum - b.sum;
        });

        // Create the result array with the first k row indices
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pairs[i].row;
        }

        return result;
    }

    private static class Pair {
        int row;
        int sum;

        public Pair(int row, int sum) {
            this.row = row;
            this.sum = sum;
        }
    }




    // sum *100 +row, sort then mod 100
    // 1 ms, 99.31%; 44.6 MB, 42.52%
    public int[] kWeakestRows_Multi100(int[][] mat, int k) {
        int[] list = new int[mat.length];
        int[] result = new int[k];
        for(int i=0;i<mat.length;i++){
            list[i] = count(mat[i])*100+i;
        }
        Arrays.sort(list);
        for(int i=0;i<k;i++){
            result[i] = list[i]%100;
        }
        return result;
    }
    public int count(int[] nums){
        int sum=0;
        for(int n:nums){
            if(n!=1){
                break;
            }
            sum+=n;
        }
        return sum;


    }


    public static void main(String[] args) {
        TheKWeakestRows1337 solution = new TheKWeakestRows1337();
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3;

        int[] weakestRows = solution.kWeakestRows(mat, k);
        System.out.println("K Weakest Rows: " + Arrays.toString(weakestRows)); // Output: [2, 0, 3]
    }



}
