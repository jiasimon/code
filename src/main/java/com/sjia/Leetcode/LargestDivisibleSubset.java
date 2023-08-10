package com.sjia.Leetcode;

import java.util.*;

public class LargestDivisibleSubset {
    // #368. Largest Divisible Subset   https://leetcode.com/problems/largest-divisible-subset/

    /*
    Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

    answer[i] % answer[j] == 0, or
    answer[j] % answer[i] == 0
    If there are multiple solutions, return any of them.

    Input: nums = [1,2,3]   Output: [1,2], Explanation: [1,3] is also accepted.
    Input: nums = [1,2,4,8] Output: [1,2,4,8]

    1 <= nums.length <= 1000
    1 <= nums[i] <= 2 * 10^9


     */


    // simliar to LIS dp
    // int[] prevIndices
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prevIndices = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndices, -1);

        int maxIndex = 0;
        int maxSize = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndices[i] = j;
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prevIndices[maxIndex];
        }

        return result;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset solution = new LargestDivisibleSubset();
        int[] nums = {1, 2, 3, 4, 8};
        List<Integer> largestDivisibleSubset = solution.largestDivisibleSubset(nums);
        System.out.println("Largest Divisible Subset: " + largestDivisibleSubset); // Output: [1, 2]
    }



}
