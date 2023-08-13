package com.sjia.Leetcode;

import java.util.Arrays;

public class CombinationSum4 {
    // #377. Combination Sum IV  https://leetcode.com/problems/combination-sum-iv/
    // compare to #322. Coin Change, #518. Coin Change II


    /*
        Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

    The test cases are generated so that the answer can fit in a 32-bit integer.

    Input: nums = [1,2,3], target = 4
    Output: 7
    Explanation:
    The possible combination ways are:
    (1, 1, 1, 1)
    (1, 1, 2)
    (1, 2, 1)
    (1, 3)
    (2, 1, 1)
    (2, 2)
    (3, 1)
    Note that different sequences are counted as different combinations.

     */

    // 1 <= nums.length <= 200
    // 1 <= nums[i] <= 1000
    // All the elements of nums are unique.
    // 1 <= target <= 1000


    // DP  dynamic programming
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }


    // recursive , Time Limit Exceeded, TLE
    public int combinationSum4_recursive(int[] nums, int target) {
        if (target == 0) return 1;

        int res =0;
        for (int i : nums) {
            if (i <= target) {  // it should be <=
                res += combinationSum4_recursive(nums,target -i);
            }
        }
        return res;
    }



    // memo, TLE 14/15
    public int combinationSum4_memo_failed(int[] nums, int target) {
        int n = nums.length;
        int[] memo = new int[target+1];
        memo[0] = 1;
        return recursive_memo(nums, target, memo);
    }

    public int recursive_memo(int[] nums, int target, int[] memo) {
        if (target == 0) return 1;
        if (memo[target] != 0) return memo[target];

        int res =0;
        for (int i : nums) {
            if (i <= target) {  // it should be <=
                res += recursive_memo(nums,target -i, memo);
            }
        }
        memo[target] = res;
        return res;
    }




    // fix memo issue, init to -1
    public int combinationSum4_memo(int[] nums, int target) {
        int n = nums.length;
        int[] memo = new int[target+1];
        Arrays.fill(memo , -1);
        memo[0] = 1;
        return helper(nums, target, memo);
    }

    private int helper(int[] nums, int target, int[] memo) {
        if (target == 0) return 1;
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i], memo);
            }
        }
        memo[target] = res;
        return res;
    }



    public static void main(String[] args) {
        CombinationSum4 cs = new CombinationSum4();
        int[] nums = {1, 2, 3};
        int target = 4;
        int count = cs.combinationSum4_memo(nums, target);
        System.out.println("Number of combinations for target " + target + ": " + count);  // output: 7

        target = 5;
        int count2 = cs.combinationSum4_memo(nums, target);
        System.out.println("Number of combinations for target " + target + ": " + count2); // output 13


    }




}
