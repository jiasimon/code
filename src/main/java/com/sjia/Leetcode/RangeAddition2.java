package com.sjia.Leetcode;

public class RangeAddition2 {
    // #598. Range Addition II  https://leetcode.com/problems/range-addition-ii/description/
    /*
    You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

    Count and return the number of maximum integers in the matrix after performing all the operations.
    Input: m = 3, n = 3, ops = [[2,2],[3,3]]    Output: 4
    Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.

    Input: m = 3, n = 3, ops = []   Output: 9
    1 <= m, n <= 4 * 10000
    0 <= ops.length <= 10000
     */

    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }

        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;

        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }

    public static void main(String[] args) {
        RangeAddition2 solution = new RangeAddition2();

        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};

        System.out.println("Test Case 1: " + solution.maxCount(m, n, ops)); // Output: 4
    }

}
