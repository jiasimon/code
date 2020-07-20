package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    // #46 https://leetcode.com/problems/permutations/

    // Runtime: 3 ms, faster than 35.95% of Java online submissions for Permutations.
    //Memory Usage: 41.8 MB, less than 6.44% of Java online submissions for Permutations.

    // Second run without change,
    //Runtime: 3 ms, faster than 35.95% of Java online submissions for Permutations.
    //Memory Usage: 39.3 MB, less than 93.09% of Java online submissions for Permutations.

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tmp, int[] nums, int start) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                tmp.add(nums[i]);
                backtrack(result, tmp, nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }

        }
    }


    public static void main(String[] args) {

        // int[] testData  = {1,2,3};
        int[] testData  = {1,2,3};
        Permutations solution = new Permutations();
        List<List<Integer>> result = solution.permute(testData);

        System.out.printf(" testData %s Three sum result is %s \n", Arrays.toString(testData),result);
    }

}
