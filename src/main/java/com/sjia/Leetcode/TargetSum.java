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



    // brute force , backtrack
    // 506 ms, 20.92%; 39.6 MB, 95.63%

    int count = 0;

    public int findTargetSumWays_backtrack(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }


    public int findTargetSumWays_dp2D(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the target sum is out of bounds, return 0
        if (target > sum || target < -sum) {
            return 0;
        }

        int n = nums.length;
        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[0][sum] = 1; // Set the initial value at sum index to 1

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (dp[i - 1][j] != 0) {
                    dp[i][j + nums[i - 1]] += dp[i - 1][j];
                    dp[i][j - nums[i - 1]] += dp[i - 1][j];
                }
            }
        }

        return dp[n][target + sum];

    }


    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int res = solution.findTargetSumWays_dp2D(nums, target);
        System.out.println("Number of ways to reach the target sum: " + res); // Output: 5


        int[] nums2 = {1, 2, 3, 4, 5};
        int target2 = 5;
        int res2 = solution.findTargetSumWays_dp2D(nums2, target2);
        System.out.println("Number of ways to reach the target sum: " + res2);


        int[] nums3 = {7,9,3,8,0,2,4,8,3,9};
        int target3 = 0;
        int res3 = solution.findTargetSumWays_dp2D(nums3, target3);
        System.out.println("Number of ways to reach the target sum: " + res3);

    }

}
