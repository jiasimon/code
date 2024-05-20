package com.sjia.Leetcode600;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthPairChain {
    // #646. Maximum Length of Pair Chain   https://leetcode.com/problems/maximum-length-of-pair-chain/description/
    /*
    #interview
    You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

    A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

    Return the length longest chain which can be formed.
     */

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[1] -b[1]);
//        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int[] pair : pairs) {
            if (pair[0] > end) {
                count++;
                end = pair[1];
            }
        }

        return count;
    }


    public static void main(String[] args) {
        MaxLengthPairChain solution = new MaxLengthPairChain();

        // Test Case
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println("Test Case 1: " + solution.findLongestChain(pairs)); // Output: 2
    }


}
