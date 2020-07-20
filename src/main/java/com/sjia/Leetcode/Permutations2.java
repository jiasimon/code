package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    // #47 https://leetcode.com/problems/permutations-ii/
    // collection of numbers that might contain duplicates, return all possible unique permutations

    // Runtime: 3 ms, faster than 50.16% of Java online submissions for Permutations II.
    //Memory Usage: 44.5 MB, less than 6.69% of Java online submissions for Permutations II.

    //

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<0 ) return result;
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tmp, int[] nums, boolean [] used) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i-1]  && (!used[i-1]) ) continue;
                used[i] = true;
                tmp.add(nums[i]);
                backtrack(result, tmp, nums, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }

        }
    }


    public static void main(String[] args) {

        // int[] testData  = {1,2,3};
        int[] testData  = {1,2,2};
        Permutations2 solution = new Permutations2();
        List<List<Integer>> result = solution.permuteUnique(testData);

        System.out.printf(" testData %s Three sum result is %s \n", Arrays.toString(testData),result);
    }

}
