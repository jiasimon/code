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

/*
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
    }*/


    // Runtime: 5 ms, faster than 50.66% of Java online submissions for Combination Sum.
    //Memory Usage: 41.6 MB, less than 11.95% of Java online submissions for Combination Sum.

    // 
    // Runtime: 3 ms, faster than 81.69% of Java online submissions for Combination Sum.
    //Memory Usage: 39.6 MB, less than 68.37% of Java online submissions for Combination Sum.

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tmp, int[] nums, int remain, int start) {
        // if (remain < 0) return;
        if ( remain == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        } else {
            for ( int i = start; i< nums.length; i++) {
                if (remain < nums[i]) {
                    break;
                }
                tmp.add(nums[i]);
                backtrack(result, tmp, nums, remain-nums[i], i);
                tmp.remove(tmp.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        // int[] testData  = {2,3,5}; 8
        // int[] testData  = {2,3,6,7}; 7
        int[] testData  = {2,3,6,7};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(testData, target);

        System.out.printf(" target %d Three sum result is %s \n",target, result);
    }

}
