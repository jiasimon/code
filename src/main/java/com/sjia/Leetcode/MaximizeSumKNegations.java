package com.sjia.Leetcode;

import java.util.Arrays;

public class MaximizeSumKNegations {
    // #1005 https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
    // 1 <= A.length <= 10000
    // 1 <= K <= 10000
    // -100 <= A[i] <= 100

    // Input: A = [4,2,3], K = 1    Output: 5
    // A = [3,-1,0,2], K = 3        Output: 6
    // A = [2,-3,-1,5,-4], K = 2    Output: 13
    // A = [3,-1,6,8], K = 4    Output: 13


    // Runtime: 1 ms, faster than 99.71% of Java online submissions for Maximize Sum Of Array After K Negations.
    // Memory Usage: 38.1 MB, less than 20.34% of Java online submissions for Maximize Sum Of Array After K Negations.
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i=0; i< A.length && A[i]<0 && K>0; i++) {
            A[i] = -A[i];
            K--;
        }
        int res = 0, tmp = Integer.MAX_VALUE;
        for (int a : A) {
            res += a;
            tmp = Math.min(tmp, a);
        }
        if (K%2==0) return res;
        else return res - 2 * tmp;
    }

}
