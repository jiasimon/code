package com.sjia.Leetcode;

import java.util.Arrays;

public class MinimumMoves {
    // #453 https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
    // Given a non-empty integer array of size n,
    // find the minimum moves required to make all array elements equal,
    // where a move is incrementing n - 1 elements by 1.


    // Runtime: 10 ms, faster than 23.46% of Java online submissions for Minimum Moves to Equal Array Elements.
    //Memory Usage: 39.8 MB, less than 86.42% of Java online submissions for Minimum Moves to Equal Array Elements.
/*
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            result += nums[i] - nums[0];
        }
        return result;
    }*/




    public static void main(String[] args) {

        //int[] testData  = {1,2,3};
        int[] testData  = {1,2,5};
        MinimumMoves solution = new MinimumMoves();
        int result = solution.minMoves(testData);

        System.out.printf(" testData %s minMoves is %s \n", Arrays.toString(testData),result);
    }


}
