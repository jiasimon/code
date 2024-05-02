package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class LargestPositiveInteger {
    // #2441. Largest Positive Integer That Exists With Its Negative
    //  https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/?envType=daily-question&envId=2024-05-02
    /*
    Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

    Return the positive integer k. If there is no such integer, return -1.
    Input: nums = [-1,10,6,7,-7,1]      Output: 7
    Input: nums = [-10,8,6,7,-2,-3]     Output: -1

     */

    public int findMaxK(int[] nums) {
        int res = -1;
        Set<Integer> seen = new HashSet<>();

        for (final int num : nums)
            if (seen.contains(-num))
                res = Math.max(res, Math.abs(num));
            else
                seen.add(num);

        return res;
    }

    

}
