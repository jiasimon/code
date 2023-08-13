package com.sjia.Leetcode;

public class WiggleSubsequence {
    // #376. Wiggle Subsequence     https://leetcode.com/problems/wiggle-subsequence/description/

    /*
    For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
    A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative.

    A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

    Given an integer array nums, return the length of the longest wiggle subsequence of nums.
    Input: nums = [1,7,4,9,2,5]     Output: 6
    Input: nums = [1,17,5,10,13,15,10,5,16,8]   Output: 7

    1 <= nums.length <= 1000
    0 <= nums[i] <= 1000
     */

    // dp, up[], down[] up[i] = down[i-1] + 1
    // 0 ms, 100%; 40 MB, 77.68%
    public int wiggleMaxLength_dp_array(int[] nums) {
        int n = nums.length;
        if (n <1) return 0;

        int[] up = new int[n+1];
        int[] down = new int[n+1];

        up[0] = 1;
        down[0] = 1;
        int res = 1;

        for (int i=1; i < n; i++) {
            if( nums[i] > nums[i-1]  ) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1] ) {
                up[i] = up[i-1] ;
                down[i] = up[i-1] + 1;
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
            res = Math.max(up[i], down[i]);
        }
        return res;
    }



     // dp, only two var: up, down
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <1) return 0;

        int up = 1;
        int down = 1;

        for (int i=1; i < n; i++) {
            if( nums[i] > nums[i-1]  ) {
                up = down + 1;
            } else if (nums[i] < nums[i-1] ) {
                down = up + 1;
            } else {
//                up = up;
//                down = down;
            }
//            res = Math.max(up[i], down[i]);
        }
        return Math.max(up, down);
    }



    public static void main(String[] args) {
        WiggleSubsequence solution = new WiggleSubsequence();
        int[] nums = {1, 7, 4, 9, 2, 5};
        int maxLength = solution.wiggleMaxLength(nums);
        System.out.println("Length of longest wiggle subsequence: " + maxLength); // Output: 6

        int[] nums2 = {1,17,5,10,13,15,10,5,16,8};
        int maxLength2 = solution.wiggleMaxLength(nums2);
        System.out.println("Length of longest wiggle subsequence: " + maxLength2); // Output: 7


    }
}
