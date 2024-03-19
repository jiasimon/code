package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualsK {
    // #560. Subarray Sum Equals K  https://leetcode.com/problems/subarray-sum-equals-k/description/

    /*
    Input: nums = [1,1,1], k = 2    Output: 2

    Input: nums = [1,2,3], k = 3    Output: 2

    1 <= nums.length <= 2 * 10^4
    -1000 <= nums[i] <= 1000
    -10^7 <= k <= 10^7
     */

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0, count 1

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubArrayEqualsK solution = new SubArrayEqualsK();

        int[] testArray = {1, 1, 1};
        int testK = 2;

        System.out.println("Test Case 1: " + solution.subarraySum(testArray, testK)); // Output: 2
    }


}
