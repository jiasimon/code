package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // #560 https://leetcode.com/problems/subarray-sum-equals-k/    #fb

    // 1 <= nums.length <= 2 * 104
    // -1000 <= nums[i] <= 1000
    // -107 <= k <= 107

    // Input: nums = [1,2,3], k = 3



    // two loops, brute force
    // Runtime: 1202 ms, faster than 6.00% of Java online submissions for Subarray Sum Equals K.
    //Memory Usage: 41.2 MB, less than 44.74% of Java online submissions for Subarray Sum Equals K.
/*    public int subarraySum(int[] nums, int k) {
        int res = 0 ;
        for (int i=0; i < nums.length; i++) {
            int sum = 0;
            for (int j=i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }*/



    // presum
    // Runtime: 1315 ms, faster than 5.04% of Java online submissions for Subarray Sum Equals K.
    //Memory Usage: 41.6 MB, less than 25.98% of Java online submissions for Subarray Sum Equals K.
/*    public int subarraySum(int[] nums, int k) {
        int res = 0 , N = nums.length;
        int[] tmp = new int[N];
        tmp[0] = nums[0];
        for (int i=1; i < N; i++) {
            tmp[i] = tmp[i-1] + nums[i];
        }
        for (int i=0; i < N; i++) {
            if (tmp[i] == k) res++;
            for (int j=i+1; j < N; j++) {
                if (tmp[j] -tmp[i] == k) res++;
            }
        }
        return res;
    }*/



    // presum + hashtable
    // Runtime: 18 ms, faster than 44.70% of Java online submissions for Subarray Sum Equals K.
    //Memory Usage: 41.5 MB, less than 30.58% of Java online submissions for Subarray Sum Equals K.
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>(); // key: presum;  value: the count
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }



    public static void main(String[] args) {
        // int[] nums = new int[]{1, 1, 1, 1};  k = 2;
        int[] nums = new int[]{3, 4, 7, 2, -3, 1};
        int k = 7;
//        int[] nums = new int[]{1};
//        int k = 0;
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int res = solution.subarraySum(nums, k);
        System.out.println("SubarraySumEqualsK is : " + res);
    }




}
