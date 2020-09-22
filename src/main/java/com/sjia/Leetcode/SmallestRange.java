package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class SmallestRange {
    // #908 https://leetcode.com/problems/smallest-range-i/
    // Input: A = [1], K = 0  Output: 0
    // Input: A = [0,10], K = 2  Output: 6
    // A = [1,3,6], K = 3    Output: 0
    // 1 <= A.length <= 10000
    // 0 <= A[i] <= 10000
    // 0 <= K <= 10000


    // Stream
    // Runtime: 3 ms, faster than 43.40% of Java online submissions for Smallest Range I.
    // Memory Usage: 39.5 MB, less than 98.78% of Java online submissions for Smallest Range I.
    public int smallestRangeI(int[] A, int K) {
        int minA = Arrays.stream(A).min().getAsInt();
        int maxA = Arrays.stream(A).max().getAsInt();
        if (maxA- minA > K*2) return maxA - minA - K*2;
        return 0;
    }


    // Runtime: 3 ms, faster than 43.40% of Java online submissions for Smallest Range I.
    //Memory Usage: 39.4 MB, less than 99.65% of Java online submissions for Smallest Range I.
/*    public int smallestRangeI(int[] A, int K) {
        int minA = Arrays.stream(A).min().getAsInt();
        int maxA = Arrays.stream(A).max().getAsInt();
        return Math.max(maxA - minA - K*2 , 0);
    }*/


    // Runtime: 2 ms, faster than 86.28% of Java online submissions for Smallest Range I.
    // Memory Usage: 39.7 MB, less than 88.37% of Java online submissions for Smallest Range I.
 /*   public int smallestRangeI(int[] A, int K) {
        int minA=A[0], maxA = A[0];
        for (int a : A) {
            minA = Math.min(a, minA);
            maxA = Math.max(a, maxA);
        }
        return Math.max(maxA - minA - K*2 , 0);
    }*/

}
