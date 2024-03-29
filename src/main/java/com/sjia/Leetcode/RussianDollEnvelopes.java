package com.sjia.Leetcode;

import java.util.*;
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



    // Arrays.binarySearch(dp, 0, maxLength, envelope[1])
    // 37ms, 98.53%; 99.05mb,  8.39%
    public int maxEnvelopes_Comparator(int[][] envelopes) {
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



    // #LIS Collections.binarySearch
    // 59ms, 49.95%; 95.02mb, 91.29%
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                if ( a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });


        // Apply Longest Increasing Subsequence (LIS)
        List <Integer> piles = new ArrayList<>(envelopes.length);

        for ( int[] envelope : envelopes) {
//            int index = Arrays.binarySearch(piles, Integer.valueOf(envelope[1]));
            int index = Collections.binarySearch(piles, envelope[1] );
            if ( index < 0) {
                index = - (index + 1);  //  index = ~index;
            }
            if ( index == piles.size()) {
                piles.add(envelope[1]);
            } else {
                piles.set(index, envelope[1]);
            }
        }

        return piles.size();

    }



    // LIS, 2 loop, TLE 85/87
    public int maxEnvelopes_dp(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                if ( a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });


        // Apply Longest Increasing Subsequence (LIS), 2 loop
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;


    }


    public static void main(String[] args) {
        RussianDollEnvelopes solution = new RussianDollEnvelopes();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int maxEnvelopes = solution.maxEnvelopes_dp(envelopes);
        System.out.println("Maximum number of envelopes: " + maxEnvelopes); // Output: 3
    }

}
