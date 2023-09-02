package com.sjia.Leetcode;

public class PartitionEqualSubsetSum {
    // #416. Partition Equal Subset Sum     https://leetcode.com/problems/partition-equal-subset-sum/
    /*
    Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
    Input: nums = [1,5,11,5]    Output: true
    Input: nums = [1,2,3,5]     Output: false

    1 <= nums.length <= 200
    1 <= nums[i] <= 100
     */


    public boolean canPartition(int[] nums) {
        int sum=0;
        for ( int n : nums) {
            sum += n;
        }

        if (sum %2 == 1) {
            return false;
        }

        int target = sum/2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for ( int coin : nums) {
//            for (int i=target; i >= 0; i--) {
            for (int i=target; i >= 0; i--) {
                if ( i >= coin ) {
                    dp[i] = dp[i] || dp[i- coin];
                }
            }
        }
        return dp[target];

    }



    // from coin to total, boolean[target +1]
    // for ( int i = target; i >= coin; i-- ) reverse order
    // 26 ms, 84.78%; 40.7 MB, 95.51%
    public boolean canPartition_dp(int[] nums) {
        int sum = 0;
        for ( int n : nums) {
            sum += n;
        }

        if ( sum %2 == 1)  return false;

        int target = sum/2 ;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int coin : nums) {
            for ( int i = target; i >= coin; i-- ) {
                dp[i] = dp[i] || dp [i-coin];
            }
        }
        return dp[target];
    }



    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        boolean canPartition = solution.canPartition(nums);
        System.out.println("Can partition into equal subsets: " + canPartition); // Output: true
    }

}
