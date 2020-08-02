package com.sjia.Leetcode;

public class MoveZeroes {

    // #283 https://leetcode.com/problems/move-zeroes/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    //Memory Usage: 39.5 MB, less than 84.61% of Java online submissions for Move Zeroes.
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length ==1) return;
        int p=0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p]=nums[i];
                p++;
            }
        }
        for (int i=p; i<nums.length; i++) {
            nums[i]=0;
        }
    }

}
