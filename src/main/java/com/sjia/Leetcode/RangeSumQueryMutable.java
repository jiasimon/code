package com.sjia.Leetcode;


// 307. Range Sum Query - Mutable   https://leetcode.com/problems/range-sum-query-mutable/description/
/*
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 */


//  980ms, 14.17%; 70.05mb, 42.99% in leetcode.cn
// TLE in https://leetcode.com/
public class RangeSumQueryMutable {



    private int[] dp;
    private int[] nums;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
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

    public void update(int index, int val) {

        int diff = val - nums[index];
        for ( int i=nums.length-1; i >= index; i--) {
            dp[i] += diff;
        }
        nums[index] = val;

    }

    public int sumRange(int left, int right) {
        if (left==0) return dp[right];
        else return dp[right] - dp[left-1];
    }




    public static void main(String[] args) {
//        int[] nums = {1, 3, 5};
        int[] nums = {0,9,5,7,3};

        RangeSumQueryMutable numArray = new RangeSumQueryMutable(nums);

        // Test cases
//        System.out.println(numArray.sumRange(0, 2)); // Output: 9 (1 + 3 + 5)
//        numArray.update(1, 2);
//        System.out.println(numArray.sumRange(0, 2)); // Output: 8 (1 + 2 + 5)


        numArray.update(4, 5);
        System.out.println(numArray.nums[4]);
        numArray.update(1, 7);
        System.out.println(numArray.nums[1]);
        numArray.update(0, 8);
        System.out.println(numArray.nums[0]);
        System.out.println(numArray.sumRange(1, 2));


    }
}
