package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    // #525. Contiguous Array   https://leetcode.com/problems/contiguous-array/description/

    /*
    given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

    Input: nums = [0,1]     Output: 2
    Input: nums = [0,1,0]   Output: 2

    1 <= nums.length <= 100000
    nums[i] is either 0 or 1.
     */


    // Map, count += nums[i] == 1 ? 1 : -1
    // 25ms, 29.53%; 55.55MB, 10.32%
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with a dummy count 0 at index -1
        int maxLen = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1; // Convert 0 to -1, 1 to 1

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {
        ContiguousArray solution = new ContiguousArray();

        int[] nums = {0, 1, 0, 1, 1, 0, 1};

        int maxLen = solution.findMaxLength(nums);
        System.out.println("Maximum length of contiguous subarray: " + maxLen);
    }

}
