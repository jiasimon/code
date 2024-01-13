package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    // #523. Continuous Subarray Sum    https://leetcode.com/problems/continuous-subarray-sum/description/

    /*
    Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

    A good subarray is a subarray where:

    its length is at least two, and
    the sum of the elements of the subarray is a multiple of k.

    Input: nums = [23,2,4,6,7], k = 6   Output: true
    Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

    Input: nums = [23,2,6,4,7], k = 6   Output: true
    Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
    42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.

    Input: nums = [23,2,6,4,7], k = 13  Output: false

     */

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // Initialize with a dummy remainder 0 at index -1

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (k != 0) {
                sum %= k;
            }

            if (remainderMap.containsKey(sum)) {
                int prevIndex = remainderMap.get(sum);
                if (i - prevIndex > 1) {
                    return true;
                }
            } else {
                remainderMap.put(sum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum solution = new ContinuousSubarraySum();

        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;

        boolean result = solution.checkSubarraySum(nums, k);
        System.out.println("Does there exist a continuous subarray with a sum multiple of " + k + "? " + result);
    }



}
