package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
    // #315. Count of Smaller Numbers After Self    https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
    /*
    Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

    Input: nums = [5,2,6,1]     Output: [2,1,1,0]
    Input: nums = [-1]          Output: [0]
    Input: nums = [-1,-1]       Output: [0,0]
     */



    // naive, 2 loop
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for ( int i =0; i< n; i++) {
            int count =0;
            for (int j = i+1; j< n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }




    public static void main(String[] args) {
        CountSmallerNumbersAfterSelf solution = new CountSmallerNumbersAfterSelf();
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = solution.countSmaller(nums);
        System.out.println(result); // Output: [2, 1, 1, 0]
    }

}
