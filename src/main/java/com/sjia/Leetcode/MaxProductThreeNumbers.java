package com.sjia.Leetcode;

import java.util.Arrays;

public class MaxProductThreeNumbers {
    // #628 https://leetcode.com/problems/maximum-product-of-three-numbers/

    // The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
    // Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer

    // Runtime: 9 ms, faster than 61.28% of Java online submissions for Maximum Product of Three Numbers.
    //Memory Usage: 41.1 MB, less than 90.75% of Java online submissions for Maximum Product of Three Numbers.
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max1 = nums[n-1] * nums[n-2] * nums[n-3];
        int max2 = nums[n-1] * nums[0] * nums[1];
        return Math.max(max1, max2);
    }

}
