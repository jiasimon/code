package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    // #300. Longest Increasing Subsequence https://leetcode.com/problems/longest-increasing-subsequence/
    /*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    Input: nums = [10,9,2,5,3,7,101,18]     Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    Input: nums = [0,1,0,3,2,3]     Output: 4
    Input: nums = [7,7,7,7,7,7,7]   Output: 1

     */




    // Brute Force, TLE
    public int lengthOfLIS_Brute(int[] nums) {
        return helperLIS(nums, -1, 0);
    }

    public int helperLIS(int[] nums, int prev, int i) {
        if(i >= nums.length) return 0;

        int takeCurrent = 0;
        int notTakeCurrent = helperLIS(nums, prev, i+1);
        if (prev == -1 || nums[i] > nums[prev]) {
            takeCurrent = 1 + helperLIS(nums, i, i+1);
        }
        return Math.max(takeCurrent, notTakeCurrent);

    }


    //  memo
    // 343ms, 15.89%; 99.63mb, 6.89%
    public int lengthOfLIS_Memo(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for(int[] row: memo) Arrays.fill(row,-1); // remember to set default as -1, default 0 did not work
        return helperLIS_Memo(nums, -1, 0,  memo);
    }

    public int helperLIS_Memo(int[] nums, int prev, int i, int[][] memo) {
        if(i >= nums.length) return 0;

        if(prev != -1 && memo[prev][i] != -1) {
            return memo[prev][i];
        }

        int takeCurrent = 0;
        int notTakeCurrent = helperLIS_Memo(nums, prev, i+1, memo);
        if (prev == -1 || nums[i] > nums[prev]) {
            takeCurrent = 1 + helperLIS_Memo(nums, i, i+1, memo);
        }
        if(prev != -1) memo[prev][i] = Math.max(takeCurrent, notTakeCurrent);
        return Math.max(takeCurrent, notTakeCurrent);
    }



    // dp
    // 40ms, 75.54%; 43.52mb, 37.11%
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }



    // piles Collections.binarySearch
    //5ms, 90.03%; 43.75mb, 25.40%
    public int lengthOfLIS_Piles(int[] nums) {
        List<Integer> piles = new ArrayList<>(nums.length);
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) pile = ~pile;
            if (pile == piles.size()) {
                piles.add(num);
            } else {
                piles.set(pile, num);
            }
        }
        return piles.size();
    }



    public int lengthOfLIS_Binary(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        int n = nums.length;
//        int[] ends = new int[n];
//        ends[0] = nums[0];

        List<Integer> piles = new ArrayList<>(nums.length);
        piles.add(nums[0]);

        for (int num: nums) {
            if (num < piles.get(0)) {
                piles.set(0,num);
            }
            else if ( num > piles.get(piles.size()-1)) {
                piles.add(num);
            } else {
                int left = 0, right = piles.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (piles.get(mid) < num) left = mid + 1;
                    else right = mid;
                }
                piles.set(right, num);
            }

        }
        return piles.size();
    }


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int result = solution.lengthOfLIS_Binary(nums);
        System.out.println("The length of the longest increasing subsequence is: " + result); // Output: The length of the longest increasing subsequence is: 4

        result = solution.lengthOfLIS_Binary(nums);
        System.out.println("lengthOfLIS_Memo: The length of the longest increasing subsequence is: " + result);
    }

}
