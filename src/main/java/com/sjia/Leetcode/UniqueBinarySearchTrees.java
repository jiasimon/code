package com.sjia.Leetcode;

public class UniqueBinarySearchTrees {
    // #96. Unique Binary Search Trees  https://leetcode.com/problems/unique-binary-search-trees/

    /*
        Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
        Input: n = 3    Output: 5
        Input: n = 1    Output: 1
        1 <= n <= 19
     */



    // dp,
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }



    // recursive
    public int numTreesRecursive(int n) {
        if (n <= 1) return 1;
        int res = 0;
        for (int i =1; i <= n; i++ ) {
            res += numTreesRecursive(i-1) * numTreesRecursive(n-i);
        }
        return res;
    }


    // Memoization
    int[] memo = new int[20]; // 1 <= n <= 19  n+1 = 20
    public int numTreesMemo(int n) {
        if (n <= 1) return 1;
        if (memo[n] != 0) {
            return memo[n];
        }
        for (int i =1; i <= n; i++ ) {
            memo[n] += numTreesMemo(i-1) * numTreesMemo(n-i);
        }
        return memo[n];
    }


    //  Catalan Numbers , need change type for big number: n
    public static int numTreesCatalan(int n) {
        return calculateFact(2*n) / (calculateFact(n) * calculateFact(n+1));
    }

    private static int  calculateFact(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }


    public static void main(String[] args) {
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        int n = 3;
        int numUniqueTrees = solution.numTreesCatalan(n);
        System.out.println("Number of unique binary search trees for n = " + n + ": " + numUniqueTrees);
        int n2 = 5;
        int numUniqueTrees2 = solution.numTreesCatalan(n2);
        System.out.println("Number of unique binary search trees for n2 = " + n2 + ": " + numUniqueTrees2);
    }


}
