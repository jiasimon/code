package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    // #39 https://leetcode.com/problems/combination-sum/
    // 1 <= candidates.length <= 30
    //1 <= candidates[i] <= 200
    //Each element of candidate is unique.
    //1 <= target <= 500


    // Runtime: 3 ms, faster than 81.69% of Java online submissions for Combination Sum.
    //Memory Usage: 42 MB, less than 6.55% of Java online submissions for Combination Sum.

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length < 1) return result;

        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayDeque<>(), result);
        return result;

    }

    private static void dfs(int[] candidates, int remain, int begin, ArrayDeque<Integer> path, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for ( int i=begin; i< candidates.length; i++) {
            if (remain < candidates[i]) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, remain-candidates[i], i, path, result);
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        // int[] testData  = {2,3,5}; 8
        // int[] testData  = {2,3,6,7}; 7
        int[] testData  = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(testData, target);

        System.out.printf(" target %d Three sum result is %s \n",target, result);
    }

}
