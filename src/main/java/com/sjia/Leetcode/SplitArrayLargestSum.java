package com.sjia.Leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum {
    // #410. Split Array Largest Sum    https://leetcode.com/problems/split-array-largest-sum

    /*
    Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

    Return the minimized largest sum of the split.

    A subarray is a contiguous part of the array.

    Input: nums = [7,2,5,10,8], k = 2   Output: 18
    Explanation: There are four ways to split nums into two subarrays.
    The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

    Input: nums = [1,2,3,4,5], k = 2    Output: 9
    The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

    1 <= nums.length <= 1000
    0 <= nums[i] <= 10^6
    1 <= k <= min(50, nums.length)
     */


    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;

        // Calculate the search space boundaries
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        // Perform binary search within the search space
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, m, mid)) {
                // If the mid value is valid, search in the left half
                right = mid;
            } else {
                // If the mid value is not valid, search in the right half
                left = mid + 1;
            }
        }

        return left;
    }


    private boolean isValid(int[] nums, int m, int maxSum) {
        int count = 1;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                // Need to split at this point
                count++;
                currentSum = num;
                if (count > m) {
                    return false;
                }
            }
        }

        return true;
    }



    // dp
    // 72 ms, 5.5%; 40.7 MB; 9.26%
    public int splitArray_dp(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        SplitArrayLargestSum solution = new SplitArrayLargestSum();
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        int largestSum = solution.splitArray(nums, m);
        System.out.println("Largest sum after splitting: " + largestSum);
    }
}
