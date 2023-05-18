package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    // #39 Combination Sum https://leetcode.com/problems/combination-sum/
    // 1 <= candidates.length <= 30
    //1 <= candidates[i] <= 200
    //Each element of candidate is unique.
    //1 <= target <= 500

    // Input: candidates = [2,3,6,7], target = 7; Output: [[2,2,3],[7]]




    // Runtime: 4 ms, faster than 59.01% of Java online submissions for Combination Sum.
    //Memory Usage: 39.2 MB, less than 6.17% of Java online submissions for Combination Sum.

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helperBacktrack(res, new ArrayList<Integer>(), candidates, target, 0 );
        return res;
    }

    private void helperBacktrack2(List<List<Integer>> res, List<Integer> tmp, int[] nums, int target, int start ) {
        if (target < 0) return;
        else if ( target == 0) {
            // res.add(tmp);   // [[], []]
            res.add(new ArrayList<> (tmp));
        } else {
            for (int i=start; i < nums.length; i++) {
                tmp.add(nums[i]);
                helperBacktrack(res, tmp, nums, target-nums[i],  i ); // not i + 1 because we can reuse same elements
                tmp.remove(tmp.size()-1);
            }
        }

    }



    // check whether to add before recursive call
    // Runtime: 2 ms, faster than 99.11% of Java online submissions for Combination Sum.
    //Memory Usage: 39.6 MB, less than 6.17% of Java online submissions for Combination Sum.
    private void helperBacktrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int target, int start ) {
        if ( target == 0) {
            // res.add(tmp);   // [[], []]
            res.add(new ArrayList<> (tmp));
        } else {
            for (int i=start; i < nums.length; i++) {
                if (nums[i] > target) break;
                tmp.add(nums[i]);
                helperBacktrack(res, tmp, nums, target-nums[i],  i );
                tmp.remove(tmp.size()-1);
            }
        }

    }



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





    public static void main(String[] args) {
        // int[] testData  = {2,3,5}; 8
        // int[] testData  = {2,3,6,7}; 7
        int[] testData  = {2,3,6,7};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(testData, target);

        System.out.printf(" target %d CombinationSum is %s \n",target, result);
    }

}
