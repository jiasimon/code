package com.sjia.Leetcode;

public class NumberGoodPairs {
    // #1512    https://leetcode.com/problems/number-of-good-pairs/
    // Given an array of integers nums.
    // A pair (i,j) is called good if nums[i] == nums[j] and i < j.

    // Input: nums = [1,2,3,1,1,3]  Output: 4
    // Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

    // Input: nums = [1,1,1,1]  Output: 6
    // Each pair in the array are good.

    // 1 <= nums.length <= 100
    // 1 <= nums[i] <= 100


    // two loops
    // Runtime: 1 ms, faster than 61.66% of Java online submissions for Number of Good Pairs.
    //Memory Usage: 36.5 MB, less than 26.54% of Java online submissions for Number of Good Pairs.
    public int numIdenticalPairs(int[] nums) {
        int res =0;
        for (int i=0; i < nums.length; i++){
            for (int j=i+1; j < nums.length; j++) {
                if (nums[j] == nums[i]) res++;
            }
        }
        return res;

    }




}
