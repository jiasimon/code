package com.sjia.Leetcode;

import java.util.Arrays;

public class LastStoneWeight {
    // #1046 https://leetcode.com/problems/last-stone-weight/

    // 1 <= stones.length <= 30
    // 1 <= stones[i] <= 1000


    // if we can modify input, since array length is small
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Last Stone Weight.
    // Memory Usage: 36.2 MB, less than 19.85% of Java online submissions for Last Stone Weight.
    public int lastStoneWeight(int[] stones) {
        int N = stones.length;
        Arrays.sort(stones);
        for (int i=N-1; i>=1; i-- ) {
            stones[i-1] = stones[i] - stones[i-1];
            Arrays.sort(stones);
        }
        return stones[0];
    }




}
