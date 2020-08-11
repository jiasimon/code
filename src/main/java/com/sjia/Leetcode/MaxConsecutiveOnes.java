package com.sjia.Leetcode;

public class MaxConsecutiveOnes {
    // #485 https://leetcode.com/problems/max-consecutive-ones/
    // Given a binary array, find the maximum number of consecutive 1s in this array.
    // [1,0,1,1,0,1], 2

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Consecutive Ones.
    //Memory Usage: 41.4 MB, less than 51.99% of Java online submissions for Max Consecutive Ones.
    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0, count=0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                result = Math.max(result, count);
                count =0; // reset to 0
            }
        }
        //return result;  if all "1"
        return Math.max(result, count);
    }


}
