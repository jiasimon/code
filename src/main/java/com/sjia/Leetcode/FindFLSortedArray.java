package com.sjia.Leetcode;

import java.util.Arrays;

public class FindFLSortedArray {

    // #34 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
    //Memory Usage: 42.6 MB, less than 72.07% of Java online submissions for Find First and Last Position of Element in Sorted Array.

    // Need follow up. 


    static int[] searchRange(int[] nums, int target) {
        int [] result = {-1 ,-1};
        int [] single = {1,1};
        if (nums.length == 0) return result;
        if (nums.length == 1) return nums[0] == target ? single:result;
        int l = 0, r = nums[nums.length-1];

        int left = twoDivide(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return result;
        }

        result[0] = left;
        result[1] = twoDivide(nums, target, false)-1;

        return result;

        }


        static int twoDivide(int[] nums, int target, boolean flag) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (flag && target == nums[mid])) { // when left, flag is true
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }

            return lo;
        }



    public static void main(String[] args) {
        int[] testData = {5,7,7,8,8,10};
        int target = 7;
        int[] result = searchRange(testData, target);
        System.out.println( "Number " + target + " result is: " + Arrays.toString(result));
    }


}
