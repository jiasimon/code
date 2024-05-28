package com.sjia.Leetcode600;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayConsecutiveSubseq {
    // #659. Split Array into Consecutive Subsequences  https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
    /*
    You are given an integer array nums that is sorted in non-decreasing order.

    Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:

    Input: nums = [1,2,3,3,4,5]     Output: true
    [1,2,3,3,4,5] --> 1, 2, 3
    [1,2,3,3,4,5] --> 3, 4, 5

    Input: nums = [1,2,3,3,4,4,5,5] Output: true
    1, 2, 3, 4, 5;      3, 4, 5

    1 <= nums.length <= 10^4
    -1000 <= nums[i] <= 1000
     */


    // freqMap, appendMap
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> appendMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freqMap.get(num) == 0) {
                continue;
            } else if (appendMap.getOrDefault(num, 0) > 0) {
                appendMap.put(num, appendMap.get(num) - 1);
                appendMap.put(num + 1, appendMap.getOrDefault(num + 1, 0) + 1);
            } else if (freqMap.getOrDefault(num + 1, 0) > 0 && freqMap.getOrDefault(num + 2, 0) > 0) {
                freqMap.put(num + 1, freqMap.get(num + 1) - 1);
                freqMap.put(num + 2, freqMap.get(num + 2) - 1);
                appendMap.put(num + 3, appendMap.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            freqMap.put(num, freqMap.get(num) - 1);
        }

        return true;
    }



    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 3, 3, 4, 5};
        SplitArrayConsecutiveSubseq solution1 = new SplitArrayConsecutiveSubseq();
        boolean result1 = solution1.isPossible(nums1);
        System.out.println("Test case 1: " + result1);  // Expected output: true

        // Test case 2
        int[] nums2 = {1, 2, 3, 3, 4, 4, 5, 5};
        SplitArrayConsecutiveSubseq solution2 = new SplitArrayConsecutiveSubseq();
        boolean result2 = solution2.isPossible(nums2);
        System.out.println("Test case 2: " + result2);  // Expected output: true

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 4, 5};
        SplitArrayConsecutiveSubseq solution3 = new SplitArrayConsecutiveSubseq();
        boolean result3 = solution3.isPossible(nums3);
        System.out.println("Test case 3: " + result3);  // Expected output: false

        // Test case 4
        int[] nums4 = {1, 2, 3, 4, 5, 5, 6, 7};
        SplitArrayConsecutiveSubseq solution4 = new SplitArrayConsecutiveSubseq();
        boolean result4 = solution4.isPossible(nums4);
        System.out.println("Test case 4: " + result4);  // Expected output: true
    }

}
