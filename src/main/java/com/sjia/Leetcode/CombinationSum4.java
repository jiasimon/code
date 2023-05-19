package com.sjia.Leetcode;

public class CombinationSum4 {
    // #377. Combination Sum IV  https://leetcode.com/problems/combination-sum-iv/
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


    // recursive , Time Limit Exceeded
    public int combinationSum4b(int[] nums, int target) {
        if (target == 0) return 1;

        int res =0;
        for (int i : nums) {
            if (i <= target) {  // it should be <=
                res += combinationSum4b(nums,target -i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        CombinationSum4 cs = new CombinationSum4();
        int[] nums = {1, 2, 3};
        int target = 4;
        int count = cs.combinationSum4b(nums, target);
        System.out.println("Number of combinations for target " + target + ": " + count);
    }




}
