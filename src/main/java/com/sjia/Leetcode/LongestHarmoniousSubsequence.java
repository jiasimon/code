package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    // #594. Longest Harmonious Subsequence     https://leetcode.com/problems/longest-harmonious-subsequence/description/
    /*
    We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

    A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

    Input: nums = [1,3,2,2,5,2,3,7]     Output: 5
    Explanation: The longest harmonious subsequence is [3,2,2,2,3].

    Input: nums = [1,2,3,4]     Output: 2

    Input: nums = [1,1,1,1]     Output: 0

    1 <= nums.length <= 2 * 10000
    -10^9 <= nums[i] <= 10^9
     */

    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, freqMap.get(key) + freqMap.get(key + 1));
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {
        LongestHarmoniousSubsequence solution = new LongestHarmoniousSubsequence();

        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println("Test Case 1: " + solution.findLHS(nums)); // Output: 5
    }



}
