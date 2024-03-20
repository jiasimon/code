package com.sjia.Leetcode;

import java.util.Arrays;

public class ArrayPartition {

    // #561. Array Partition https://leetcode.com/problems/array-partition-i/
    /*
    Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
    Input: nums = [1,4,3,2]         Output: 4

    Input: nums = [6,2,6,5,1,2]     Output: 9
    Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.

    1 <= n <= 104
    nums.length == 2 * n
    -10000 <= nums[i] <= 10000
     */

    //Runtime: 14 ms, faster than 46.28% of Java online submissions for Array Partition I.
    //Memory Usage: 41.4 MB, less than 82.23% of Java online submissions for Array Partition I.
/*
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for (int i=0; i< nums.length; i +=2)
            result += nums[i];
        return result;
    }*/


    // Runtime: 10 ms, faster than 95.53% of Java online submissions for Array Partition I.
    //Memory Usage: 41.4 MB, less than 78.01% of Java online submissions for Array Partition I.
    public int arrayPairSum_sort(int[] nums) {
        Arrays.sort(nums);
        int result=0, i=0;
        while (i< nums.length ) {
            result += nums[i++];
            i++;
        }
        return result;
    }


    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayPartition solution = new ArrayPartition();

        int[] testArray = {1, 4, 3, 2};

        System.out.println("Test Case 1: " + solution.arrayPairSum(testArray)); // Output: 4
    }


}
