package com.sjia.Leetcode;

public class NondecreasingArray {

    // #665 https://leetcode.com/problems/non-decreasing-array/

    //  non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2)
    //  1 <= n <= 10 ^ 4
    //- 10 ^ 5 <= nums[i] <= 10 ^ 5
    //  1 2 4 5 3 5
    //  1 2 2 5 3 5
    //  4 2 3


    public boolean checkPossibility(int[] nums) {
        if (nums.length<3) return true;
        int result=0;
        for (int i=1; i<nums.length && result<2; i++) {
            if (nums[i] < nums[i-1] ) {
                result++;
                if (i-2 <0 || nums[i] >= nums[i-2] )  nums[i-1]=nums[i];
                else nums[i] =nums[i-1];
            }
        }
        return result < 2 ;

    }



}
