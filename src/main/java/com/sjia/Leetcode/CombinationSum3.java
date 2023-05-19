package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    // #216. Combination Sum III Combination Sum https://leetcode.com/problems/combination-sum-iii/
    // refer to #39 #40. Combination Sum II  https://leetcode.com/problems/combination-sum-ii/
    /*
    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
	• Only numbers 1 through 9 are used.
	• Each number is used at most once.

    Input: k = 3, n = 7
    Output: [[1,2,4]]


    Input: k = 3, n = 9
    Output: [[1,2,6],[1,3,5],[2,3,4]]

    • 2 <= k <= 9
    1 <= n <= 60
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtrack(res, new ArrayList<>(), candidates, n, 0, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums, int target, int start, int k) {
        if (tmp.size() > k) return;
        else if (target == 0 && tmp.size() == k ) {
            res.add(new ArrayList<>(tmp));
        } else {
            for ( int i = start; i < nums.length; i++) {
                if (nums[i] > target) break;
                tmp.add(nums[i]);
                backtrack(res, tmp, nums, target - nums[i], i+1, k);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum3 cs = new CombinationSum3();
        int k = 3;
//        int n = 7;
        int n = 9;
        List<List<Integer>> combinations = cs.combinationSum3(k, n);
        System.out.println("Combinations for k=" + k + " and n=" + n + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }


}
