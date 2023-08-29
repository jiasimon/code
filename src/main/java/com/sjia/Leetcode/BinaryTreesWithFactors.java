package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {
    // #823. Binary Trees With Factors  https://leetcode.com/problems/binary-trees-with-factors/

    /*
    Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

    We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

    Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.
    Input: arr = [2,4]      Output: 3
    Explanation: We can make these trees: [2], [4], [4, 2, 2]

    Input: arr = [2,4,5,10] Output: 7
    Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].

    1 <= arr.length <= 1000
    2 <= arr[i] <= 10^9

     */


    // dp , map,
    // 20 ms, 73.91%; 44.6 MB, 5.59%
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);

        int MOD = 1000000007;

        Map<Integer, Long> dp = new HashMap<>();

        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L); // Each number itself can be a single node tree

            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int complement = arr[i] / arr[j];
                    if (dp.containsKey(complement)) {
                        dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(complement)) % MOD);
                    }
                }
            }

            total = (total + dp.get(arr[i])) % MOD;
        }

        return (int) total;
    }

    public static void main(String[] args) {
        BinaryTreesWithFactors solution = new BinaryTreesWithFactors();
        int[] arr = {2, 4, 5, 10};
        int numTrees = solution.numFactoredBinaryTrees(arr);
        System.out.println("Number of factored binary trees: " + numTrees);
    }




}
