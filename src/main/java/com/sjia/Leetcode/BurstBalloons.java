package com.sjia.Leetcode;

public class BurstBalloons {
    // #312. Burst Balloons     https://leetcode.com/problems/burst-balloons/description/
    /*
    You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

    If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

    Return the maximum coins you can collect by bursting the balloons wisely.

    Input: nums = [3,1,5,8]
    Output: 167
    Explanation:
    nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
    coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

     */




    // memo (i,j) inclusive
    // 101ms, 61.56%; 41.41mb, 76.50%
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        int[][] memo = new int[n + 2][n + 2];
        return burstBalloons(balloons, 1, n, memo);
    }

    private int burstBalloons(int[] balloons, int left, int right, int[][] memo) {
        if (left > right) {
            return 0;
        }

        // memo[left][right],  left and right are inclusive
        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int maxCoins = 0;
        for (int i = left; i <= right; i++) { // from 1 to n inclusive
            int coins = balloons[left - 1] * balloons[i] * balloons[right + 1];
            coins += burstBalloons(balloons, left, i - 1, memo);
            coins += burstBalloons(balloons, i + 1, right, memo);
            maxCoins = Math.max(maxCoins, coins);
        }

        memo[left][right] = maxCoins;
        return maxCoins;
    }



    // memo , (i,j) exclusive, inside range, burst the last one
    public int maxCoins_memo(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n + 2];
        tmp[0] = 1;
        tmp[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            tmp[i + 1] = nums[i];
        }

        int[][] memo = new int[n + 2][n + 2];
        return burstBalloons_memo(tmp, 0, n+1, memo);
    }

    private int burstBalloons_memo(int[] balloons, int left, int right, int[][] memo) {
        if (left == right -1) {
            return 0;
        }

        // memo[left][right],  left and right are exclusive
        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int res = 0;
        for (int i = left + 1; i < right; i++) {  // for exclusive, i starts at left + 1
            int coins = balloons[left ] * balloons[i] * balloons[right ];
            coins += burstBalloons_memo(balloons, left, i , memo);
            coins += burstBalloons_memo(balloons, i , right, memo);
            res = Math.max(res, coins);
        }

        memo[left][right] = res;
        return res;
    }



    // dp bottom up, inclusive
    // 39 ms, 89.79%; 42.15mb, 11.47%
    public int maxCoins_dp(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n + 2];
        tmp[0] = 1;
        tmp[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            tmp[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    int coins = tmp[left - 1] * tmp[i] * tmp[right + 1];
                    coins += dp[left][i - 1] + dp[i + 1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        return dp[1][n];

    }



    // dp bottom up, exclusive
    //
    public int maxCoins_dp2(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n + 2];
        tmp[0] = 1;
        tmp[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            tmp[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // from end to start
        for (int left = n; left >=0; left--){
            for (int right = left+1; right < n+2; right++) {
                for ( int k = left +1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][k] + dp[k][right]
                            + tmp[left]*tmp[k]*tmp[right] );
                }
            }
        }
        return dp[0][n + 1];

    }



    public static void main(String[] args) {
        BurstBalloons solution = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        int result = solution.maxCoins_dp2(nums);
        System.out.println(result); // Output: 167

        int[] nums2 = {3, 1, 2, 5, 8};
        int result2 = solution.maxCoins_dp2(nums2);
        System.out.println(result2); // Output: 188
    }


}
