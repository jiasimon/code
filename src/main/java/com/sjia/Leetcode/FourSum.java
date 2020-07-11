package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    // #18 https://leetcode.com/problems/4sum/

    // Move i,j to remove dup
    // Runtime: 13 ms, faster than 77.03% of Java online submissions for 4Sum.
    // Memory Usage: 39.7 MB, less than 77.46% of Java online submissions for 4Sum.


    static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);

        if (nums[0] * 4 > target) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++)
            for (int j = i + 1; j < nums.length - 2; j++) {
                int lo = j + 1, hi = nums.length - 1, tmp = target - nums[i] - nums[j];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == tmp) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < tmp) {
                        lo++;
                    } else {
                        hi--;
                    }
                    while ( nums[j]==nums[j+1] && j < nums.length - 2) j++;
                }
                while ( nums[i]==nums[i+1] && i < nums.length - 3)  i++;
            }
            return res;
    }


    public static void main(String[] args) {


        // int[] testData = {1, 0, -1, 0, -2, 2};
        // int[] testData  = {-3,-2,-1,0,0,1,2,3};
        // int[] testData  = {1,-2,-5,-4,-3,3,3,5};
        int[] testData  = {-1,-5,-5,-3,2,5,0,4};
        int target = -7;
        List<List<Integer>> result = fourSum(testData, target);

        System.out.printf(" Three sum result is %s \n", result);
    }
}
