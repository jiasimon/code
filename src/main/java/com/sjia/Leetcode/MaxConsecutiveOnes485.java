package com.sjia.Leetcode;

public class MaxConsecutiveOnes485 {
    // #485. Max Consecutive Ones   https://leetcode.com/problems/max-consecutive-ones/description/

    /*
    Given a binary array nums, return the maximum number of consecutive 1's in the array.

    Input: nums = [1,1,0,1,1,1]     Output: 3
    Input: nums = [1,0,1,1,0,1]     Output: 2

    1 <= nums.length <= 100000
    nums[i] is either 0 or 1
     */


    // 
    public int findMaxConsecutiveOnes(int[] nums) {
        int res=0, count=0;

        for ( int n : nums ) {
            if (n==1) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        MaxConsecutiveOnes485 solution = new MaxConsecutiveOnes485();
        int[] nums = {1, 1, 0, 1, 1, 1};

        int maxConsecutiveOnes = solution.findMaxConsecutiveOnes(nums);
        System.out.println("Max Consecutive Ones: " + maxConsecutiveOnes);
    }
}
