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
    // 13ms,  99.06%; 42.09mb, 86.73%
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



    // 15ms, 85.63%; 41.88mb, 95.58%
    public List<Integer> largestDivisibleSubset_dp(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            g[i] = prev;
        }

        // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }

        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }


    public static void main(String[] args) {
        LargestDivisibleSubset solution = new LargestDivisibleSubset();
        int[] nums = {1, 2, 3, 4, 8};
        List<Integer> largestDivisibleSubset = solution.largestDivisibleSubset(nums);
        System.out.println("Largest Divisible Subset: " + largestDivisibleSubset); // Output: [1, 2]
    }



}
