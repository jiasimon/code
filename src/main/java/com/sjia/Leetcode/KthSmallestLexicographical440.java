package com.sjia.Leetcode;

public class KthSmallestLexicographical440 {
    // #440. K-th Smallest in Lexicographical Order     https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/

    /*
    Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

    Input: n = 13, k = 2        Output: 10
    Input: n = 1, k = 1         Output: 1

    1 <= k <= n <= 10^9
     */



    // 0 ms, 100%; 39.2 MB, 67.11%
    public int findKthNumber(int n, int k) {
        int current = 1;

        // Move to the next lexicographically smaller number
        k--;

        while (k > 0) {
            int steps = calculateSteps(n, current, current + 1);

            if (steps <= k) {
                // Move to the next sibling in the tree
                current++;
                k -= steps;
            } else {
                // Move to the first child in the tree
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private int calculateSteps(int n, long current, long next) {
        int steps = 0;

        // <=  instead < , faled on N=10, k=3
        while (current <= n) {
            steps += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }

        return steps;
    }

    public static void main(String[] args) {
        KthSmallestLexicographical440 solution = new KthSmallestLexicographical440();
        int n = 10;
        int k = 3;
        int kthSmallest = solution.findKthNumber(n, k);
        System.out.println("K-th Smallest: " + kthSmallest); // Output: 10
    }
}
