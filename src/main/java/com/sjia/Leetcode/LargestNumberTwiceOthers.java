package com.sjia.Leetcode;

public class LargestNumberTwiceOthers {
    // #747 https://leetcode.com/problems/largest-number-at-least-twice-of-others/
    //  integer array nums always exactly one largest element.
    // If it is, return the index of the largest element, otherwise return -1.
    //nums will have a length in the range [1, 50].
    //Every nums[i] will be an integer in the range [0, 99].

    // Runtime: 1 ms, faster than 47.36% of Java online submissions for Largest Number At Least Twice of Others.
    //Memory Usage: 39.6 MB, less than 16.09% of Java online submissions for Largest Number At Least Twice of Others.
    public int dominantIndex(int[] nums) {
        int max = 0, secondMax =0, maxIndex=-1;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (max >= secondMax * 2) return maxIndex;
        else return -1;
    }

}
