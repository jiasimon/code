package com.sjia.Leetcode;

public class DIStringMatch {
    // #942 https://leetcode.com/problems/di-string-match/
    // Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
    //
    // If S[i] == "I", then A[i] < A[i+1]
    // If S[i] == "D", then A[i] > A[i+1]

    // Runtime: 2 ms, faster than 95.17% of Java online submissions for DI String Match.
    //Memory Usage: 40.2 MB, less than 98.44% of Java online submissions for DI String Match.

    public int[] diStringMatch(String S) {
        int N=S.length();
        int[] res = new int[N+1];
        int low=0, high =N;
        for (int i=0; i< N; i++ ) {
            if (S.charAt(i) == 'I') res[i] = low++;
            else res[i] = high--;
        }
        res[N]=low;
        return res;
    }

}
