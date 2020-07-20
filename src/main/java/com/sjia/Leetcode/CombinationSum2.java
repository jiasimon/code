package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    // #40 https://leetcode.com/problems/combination-sum-ii/
    // Each number in candidates may only be used once in the combination.

    // Runtime: 3 ms, faster than 84.34% of Java online submissions for Combination Sum II.
    //Memory Usage: 39.6 MB, less than 66.59% of Java online submissions for Combination Sum II.

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
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
                if (i > start && nums[i] == nums[i-1]) continue;
                if (remain < nums[i]) {
                    break;
                }
                tmp.add(nums[i]);
                backtrack(result, tmp, nums, remain-nums[i], i + 1);
                tmp.remove(tmp.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        // int[] testData  = {2,5,2,1,2}; 5
        // int[] testData  = {10,1,2,7,6,1,5}; 8
        int[] testData  = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> result = solution.combinationSum2(testData, target);

        System.out.printf(" target %d CombinationSum2 result is %s \n",target, result);
    }


}
