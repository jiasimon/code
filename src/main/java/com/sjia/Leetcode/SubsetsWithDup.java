package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    // #90. Subsets II  Subsets2 https://leetcode.com/problems/subsets-ii/
    // a collection of integers that might contain duplicates, nums,
    // return all possible subsets (the power set).
    // Input: nums = [1,2,2] Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]


    // Runtime: 1 ms, faster than 99.89% of Java online submissions for Subsets II.
    //Memory Usage: 39.8 MB, less than 46.96% of Java online submissions for Subsets II.

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tmp, int[] nums, int start) {
        result.add(new ArrayList<>(tmp));
        for ( int i = start; i< nums.length; i++) {
            if ( i > start && nums[i]== nums[i-1]) continue; // remove duplicate
            tmp.add(nums[i]);
            backtrack(result, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }


    public static void main(String[] args) {

        // int[] testData  = {1,2,2,3};
        int[] testData  = {1,2,2};
        SubsetsWithDup solution = new SubsetsWithDup();
        List<List<Integer>> result = solution.subsetsWithDup(testData);

        System.out.printf(" testData %s Subsets with duplicate result is %s \n", Arrays.toString(testData),result);
    }


}
