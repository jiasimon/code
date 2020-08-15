package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestHarmoSubseq {

    // #594 https://leetcode.com/problems/longest-harmonious-subsequence/
    // harmounious array as an array where the difference
    // between its maximum value and its minimum value is exactly 1

    // Runtime: 16 ms, faster than 89.69% of Java online submissions for Longest Harmonious Subsequence.
    //Memory Usage: 40.7 MB, less than 67.78% of Java online submissions for Longest Harmonious Subsequence.
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        int result=0;
        for (int n : nums) {
            tmp.put(n, tmp.getOrDefault(n,0)+1);
        }
        for ( int key: tmp.keySet() ) {
            if (tmp.containsKey(key + 1) ){
                result = Math.max( result, tmp.get(key) + tmp.get(key+1) );
            }
        }
        return result;
    }

}
