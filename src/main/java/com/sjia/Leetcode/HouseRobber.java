package com.sjia.Leetcode;

import java.util.Arrays;

public class HouseRobber {
    // #198. House Robber https://leetcode.com/problems/house-robber/

    /*
    Given an integer array nums representing the amount of money of each house,
    return the maximum amount of money you can rob tonight without alerting the police.

    Input: nums = [1,2,3,1]     Output: 4
    Input: nums = [2,7,9,3,1]   Output: 12

     */

    // DP, Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
    //Memory Usage: 38.8 MB, less than 5.09% of Java online submissions for House Robber.

    public int rob(int[] nums) {
        int q=0, z=0, result=0;
        for (int i=0; i<nums.length; i++ ) {
            result = Math.max(q + nums[i], z);
            q = z;
            z = result;
        }
        return result;
    }

    // Recursive, TLE, Time Limit Exceeded
    public int robRecursive(int[] nums) {
        return rob(nums, nums.length - 1);
    }
    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }




    // DP, memo
    // 0 ms, 100% ; 40 MB, 67.44%
    public int robRecursiveMemo(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robMemo(nums, nums.length - 1, memo);
    }
    private int robMemo(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if(memo[i] != -1) return memo[i];
        int res = Math.max(robMemo(nums, i - 2, memo) + nums[i], robMemo(nums, i - 1, memo));
        memo[i] = res;
        return res;
    }



    // Iterative
    public int robIterative(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {

        //int[] testData  = {0,0};
        int[] testData = {2, 7, 9, 3 ,1};

        HouseRobber solution = new HouseRobber();
        int result = solution.rob(testData);

        System.out.printf(" testData  %s , rob max is %s \n",Arrays.toString(testData), result);

        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        int maxAmount1 = solution.rob(nums1);
        System.out.println("Maximum Amount Test Case 1: " + maxAmount1);  // Expected output: 4

        // Test case 2
        int[] nums2 = {2, 7, 9, 3, 1};
        int maxAmount2 = solution.rob(nums2);
        System.out.println("Maximum Amount Test Case 2: " + maxAmount2);  // Expected output: 12
    }

}
