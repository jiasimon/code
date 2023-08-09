package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    // #354. Russian Doll Envelopes https://leetcode.com/problems/russian-doll-envelopes/description/
    /*
    #LIS
    You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

    One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

    Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

    Note: You cannot rotate an envelope.

    Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]    Output: 3
    Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
    Input: envelopes = [[1,1],[1,1],[1,1]]      Output: 1

    1 <= envelopes.length <= 10^5
    envelopes[i].length == 2
     */


    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        // Sort the envelopes array based on width (ascending) and height (descending)
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1]; // Sort by height in descending order
                } else {
                    return a[0] - b[0]; // Sort by width in ascending order
                }
            }
        });

        // Apply Longest Increasing Subsequence (LIS) algorithm on heights
        int[] dp = new int[envelopes.length];
        int maxLength = 0;

        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, maxLength, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == maxLength) {
                maxLength++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes solution = new RussianDollEnvelopes();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int maxEnvelopes = solution.maxEnvelopes(envelopes);
        System.out.println("Maximum number of envelopes: " + maxEnvelopes); // Output: 3
    }

}
