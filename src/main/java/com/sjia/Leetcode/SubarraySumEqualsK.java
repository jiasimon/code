package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // #560 https://leetcode.com/problems/subarray-sum-equals-k/    #fb

    // 1 <= nums.length <= 2 * 104
    // -1000 <= nums[i] <= 1000
    // -107 <= k <= 107



    // two loops, brute force
    // Runtime: 1202 ms, faster than 6.00% of Java online submissions for Subarray Sum Equals K.
    //Memory Usage: 41.2 MB, less than 44.74% of Java online submissions for Subarray Sum Equals K.
    public int subarraySum(int[] nums, int k) {
        int res = 0 ;
        for (int i=0; i < nums.length; i++) {
            int sum = 0;
            for (int j=i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }



/*    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }*/



    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }




}
