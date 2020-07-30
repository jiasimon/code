package com.sjia.Leetcode;

import java.util.Arrays;

public class ContainsDuplicate {
    // #217 check duplicate in array


    // Sort changes original array, may work on a copy
    // Runtime: 4 ms, faster than 88.85% of Java online submissions for Contains Duplicate.
    //Memory Usage: 43.1 MB, less than 94.99% of Java online submissions for Contains Duplicate.

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] testData  = {-1,-5,-5,-3,2,5,0,4};
        ContainsDuplicate solution = new ContainsDuplicate();
        boolean result = solution.containsDuplicate(testData);
        System.out.printf("array %s contain duplicate : %s", Arrays.toString(testData), result);

    }

}
