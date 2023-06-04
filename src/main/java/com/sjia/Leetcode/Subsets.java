package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    // #78. Subsets https://leetcode.com/problems/subsets/

    // Runtime: 1 ms, faster than 76.03% of Java online submissions for Subsets.
    //Memory Usage: 39.7 MB, less than 52.33% of Java online submissions for Subsets.

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tmp, int[] nums, int start) {
        result.add(new ArrayList<>(tmp));
        for ( int i = start; i< nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(result, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }



    // Bitmask
    // for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
    //  generate bitmask, from 0..00 to 1..11
    //  String bitmask = Integer.toBinaryString(i).substring(1);
    public List<List<Integer>> subsetsBitmask(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }

    public static void main(String[] args) {

        // int[] testData  = {1,2,3};
        int[] testData  = {1,2};
        Subsets solution = new Subsets();
        List<List<Integer>> result = solution.subsets(testData);

        System.out.printf(" testData %s Subsets result is %s \n", Arrays.toString(testData),result);
    }

}
