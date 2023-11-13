package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonDecreasingSubsequences491 {
    // #491. Non-decreasing Subsequences    https://leetcode.com/problems/non-decreasing-subsequences/

    /*
    Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

    Input: nums = [4,6,7,7]
    Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

    Input: nums = [4,4,3,2,1]   Output: [[4,4]]

    1 <= nums.length <= 15
    -100 <= nums[i] <= 100
     */

    // backtrack(nums, 0, currentList, result)
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(nums, 0, currentList, result);
        return result;
    }


    private void backtrack(int[] nums, int start, List<Integer> currentList, List<List<Integer>> result) {
        if (currentList.size() > 1) {
            result.add(new ArrayList<>(currentList));
        }

        HashSet<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!used.contains(nums[i]) && (currentList.isEmpty() || nums[i] >= currentList.get(currentList.size() - 1))) {
                used.add(nums[i]);
                currentList.add(nums[i]);
                backtrack(nums, i + 1, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NonDecreasingSubsequences491 solution = new NonDecreasingSubsequences491();
        int[] nums = {4, 6, 7, 7};

        List<List<Integer>> subsequences = solution.findSubsequences(nums);
        System.out.println("Non-decreasing Subsequences: " + subsequences);
    }

}
