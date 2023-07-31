package com.sjia.Leetcode;

public class RangeSumQuery {

    // #303. Range Sum Query - Immutable https://leetcode.com/problems/range-sum-query-immutable/

    /*
    Given an integer array nums, handle multiple queries of the following type:

    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
    Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

    [[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]    Output [null, 1, -1, -3]


     */



    //  prefix sum
    static class NumArray {

        private int[] dp;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            if (nums.length>0) {
                dp = new int[nums.length];
                dp[0]= nums[0];
                for (int i = 1; i< nums.length; i++){
                    dp[i] = nums[i] + dp[i-1];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i==0) return dp[j];
            else return dp[j] - dp[i-1];
        }
    }


    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        // Test cases
        System.out.println(numArray.sumRange(0, 2)); // Output: 1 (-2 + 0 + 3)
        System.out.println(numArray.sumRange(2, 5)); // Output: -1 (3 + -5 + 2 + -1)
        System.out.println(numArray.sumRange(0, 5)); // Output: -3 (-2 + 0 + 3 + -5 + 2 + -1)
    }


}
