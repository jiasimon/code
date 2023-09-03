package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORInArray421 {
    // #421. Maximum XOR of Two Numbers in an Array     https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/

    /*
    Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

    Input: nums = [3,10,5,25,2,8]       Output: 28
    Explanation: The maximum result is 5 XOR 25 = 28.

    Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]     Output: 127

    1 <= nums.length <= 2 * 10^5
    0 <= nums[i] <= 2^31 - 1
     */


    // brute
    // TLE, 41 / 45
    public int findMaximumXOR_brute(int[] nums) {
        int res = Integer.MIN_VALUE;
        for ( int i=0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;

    }


    // HashSet, from high bit to low
    // formula: if a ^ b = c then a ^ c = b ,  b ^ c = a
    // 561 ms, 71.73%; 84.2 MB, 92.34%
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            // note1:  how to get mask
            // or  mask = mask ^ (1 << i);
            mask = mask | (1 << i);

            // System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // note: use &
                set.add(num & mask);
            }

            int tmp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ tmp)) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }




    public static void main(String[] args) {
        MaximumXORInArray421 solution = new MaximumXORInArray421();
        int[] nums = {3, 10, 5, 25, 2, 8};
        int maxXOR = solution.findMaximumXOR(nums);
        System.out.println("Maximum XOR in the array: " + maxXOR);  // res: 28
    }

}
