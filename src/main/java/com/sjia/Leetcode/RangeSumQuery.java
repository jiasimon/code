package com.sjia.Leetcode;

public class RangeSumQuery {

    // #303 https://leetcode.com/problems/range-sum-query-immutable/

    // Runtime: 7 ms, faster than 79.44% of Java online submissions for Range Sum Query - Immutable.
    //Memory Usage: 42.6 MB, less than 18.94% of Java online submissions for Range Sum Query - Immutable.

    class NumArray {

        private int[] dp;

        public NumArray(int[] nums) {
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


}
