package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KdiffPair {
    // #532 https://leetcode.com/problems/k-diff-pairs-in-an-array/
    // Input: [3, 1, 4, 1, 5], k = 2,  Output: 2

    // Runtime: 8 ms, faster than 77.02% of Java online submissions for K-diff Pairs in an Array.
    //Memory Usage: 40.1 MB, less than 70.95% of Java online submissions for K-diff Pairs in an Array.
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n :  nums) {
            map.put(n, map.getOrDefault(n,0) + 1 );
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    result++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    result++;
                }
            }
        }
        return result;

    }


    public static void main(String[] args) {
        //int[] testData  = {1, 1, 1, 4, 5, 4};
        int[] testData  = {3, 1, 4, 1, 5};
        int k = 0;
        KdiffPair solution = new KdiffPair();
        int result = solution.findPairs(testData, k);

        System.out.printf(" testData %s , k : %s , pairs are %s \n", Arrays.toString(testData),k ,result);
    }

}
