package com.sjia.Leetcode;

import java.util.Arrays;

public class MinimumMoves {
    // #453. Minimum Moves to Equal Array Elements https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
    // #stream  #interview

    /*
    Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

    In one move, you can increment n - 1 elements of the array by 1.
    Input: nums = [1,2,3]       Output: 3
    Input: nums = [1,1,1]       Output: 0
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
     */


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



    //Math, Sum + m(n-1) = (min+m) * n    so m = sum - min*n
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Moves to Equal Array Elements.
    //Memory Usage: 39.7 MB, less than 92.37% of Java online submissions for Minimum Moves to Equal Array Elements.
    public int minMoves(int[] nums) {
        int min= Integer.MAX_VALUE, sum=0;
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];
            min = Math.min(nums[i], min);
        }
        return sum- min* nums.length;

    }


    // stream sum and min, slow
    // 7 ms, 36.55%; 43.9 MB, 61.65%
    public int minMoves_stream(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int min = Arrays.stream(nums).min().getAsInt();
        return sum - min * nums.length;
    }


    public static void main(String[] args) {

        //int[] testData  = {1,2,3};
        int[] testData  = {1,2,5};
        MinimumMoves solution = new MinimumMoves();
        int result = solution.minMoves(testData);

        System.out.printf(" testData %s minMoves is %s \n", Arrays.toString(testData),result);
    }


}
