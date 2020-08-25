package com.sjia.Leetcode;

import java.util.Arrays;

public class PivotIndex {
    // #724 https://leetcode.com/problems/find-pivot-index/

    // pivot index as the index where the sum of all the numbers to the left of the index is equal
    // to the sum of all the numbers to the right of the index.
    // If no such index exists, we should return -1


    // Runtime: 2 ms, faster than 54.30% of Java online submissions for Find Pivot Index.
    //Memory Usage: 50 MB, less than 9.05% of Java online submissions for Find Pivot Index.

    // Use Stream, Runtime: 12 ms, faster than 12.00% of Java online submissions for Find Pivot Index.
    //Memory Usage: 50.1 MB, less than 8.33% of Java online submissions for Find Pivot Index.

    public int pivotIndex(int[] nums) {
        int total=0, leftSum=0;
/*        for (int n : nums) {
            total += n;
        }*/
        total = Arrays.stream(nums).sum();


        for (int i =0; i< nums.length; i++) {
            if (leftSum *2 == total - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


}
