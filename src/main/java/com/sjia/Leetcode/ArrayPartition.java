package com.sjia.Leetcode;

import java.util.Arrays;

public class ArrayPartition {

    // #561 https://leetcode.com/problems/array-partition-i/

    //Runtime: 14 ms, faster than 46.28% of Java online submissions for Array Partition I.
    //Memory Usage: 41.4 MB, less than 82.23% of Java online submissions for Array Partition I.
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for (int i=0; i< nums.length; i +=2)
            result += nums[i];
        return result;
    }


}
