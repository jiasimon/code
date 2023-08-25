package com.sjia.Leetcode;

public class TargetSum {
    // #494. Target Sum     https://leetcode.com/problems/target-sum/

    // beibao_01 , #dfs

    /*
    You are given an integer array nums and an integer target.

    You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
    Return the number of different expressions that you can build, which evaluates to target.

    1 <= nums.length <= 20
    0 <= nums[i] <= 1000

    -1000 <= target <= 1000

    {1,2,3,4}
     */



    // subsetSum = ( total + target )/ 2
    // 4 ms, 94.6%; 39.8 MB, 95.44%
    public int findTargetSumWays(int[] nums, int target) {

        int total= 0;
        for ( int n : nums) {
            total += n;
        }

        if ( total < Math.abs(target) ) {
            return 0;
        }

        // for test3
        if ( (total + target) %2 ==1) {
            return 0;
        }

        // subset with "+", subsetSum as target
        int subsetSum = ( total + target )/ 2;

        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // Base case

        for ( int num : nums) {
            for ( int i = subsetSum; i >= num; i-- ) {
                    dp[i] += dp[i - num];
            }
        }

        return dp[subsetSum];

    }

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int res = solution.findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach the target sum: " + res); // Output: 5

        int[] nums2 = {1, 2, 3, 4, 5};
        int target2 = 5;
        int res2 = solution.findTargetSumWays(nums2, target2);
        System.out.println("Number of ways to reach the target sum: " + res2);


        int[] nums3 = {7,9,3,8,0,2,4,8,3,9};
        int target3 = 0;
        int res3 = solution.findTargetSumWays(nums3, target3);
        System.out.println("Number of ways to reach the target sum: " + res3);

    }

}
