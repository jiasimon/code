package com.sjia.Leetcode600;

public class KthSmallestMultiplicationTable {
    // #668. Kth Smallest Number in Multiplication Table    https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
    /*
    Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).

    Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

    Input: m = 3, n = 3, k = 5  Output: 3
    Explanation: The 5th smallest number is 3.

    Input: m = 2, n = 3, k = 6      Output: 6
    Explanation: The 6th smallest number is 6.

    1 <= m, n <= 3 * 10000
     */

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessEqual(mid, m, n) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int countLessEqual(int x, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallestMultiplicationTable solution = new KthSmallestMultiplicationTable();

        // Test case 1
        int m1 = 3, n1 = 3, k1 = 5;
        System.out.println("Test case 1: " + solution.findKthNumber(m1, n1, k1));  // Expected output: 3

        // Test case 2
        int m2 = 2, n2 = 3, k2 = 6;
        System.out.println("Test case 2: " + solution.findKthNumber(m2, n2, k2));  // Expected output: 6

        // Test case 3
        int m3 = 3, n3 = 3, k3 = 7;
        System.out.println("Test case 3: " + solution.findKthNumber(m3, n3, k3));  // Expected output: 6

        // Test case 4
        int m4 = 4, n4 = 5, k4 = 9;
        System.out.println("Test case 4: " + solution.findKthNumber(m4, n4, k4));  // Expected output: 5

        // Test case 5
        int m5 = 5, n5 = 5, k5 = 15;
        System.out.println("Test case 5: " + solution.findKthNumber(m5, n5, k5));  // Expected output: 9
    }

}
