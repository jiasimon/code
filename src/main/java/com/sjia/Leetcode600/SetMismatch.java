package com.sjia.Leetcode600;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    // #645. Set Mismatch   https://leetcode.com/problems/set-mismatch/description/
    /*
    #interview
    Input: nums = [1,2,2,4]     Output: [2,3]
    Input: nums = [1,1]         Output: [1,2]
     */

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            if (set.contains(num)) {
                result[0] = num;
            }
            set.add(num);
            actualSum += num;
        }

        result[1] = sum - (actualSum - result[0]);
        return result;
    }

    public static void main(String[] args) {
        SetMismatch solution = new SetMismatch();

        // Test Case
        int[] nums = {1, 2, 2, 4};
        int[] result = solution.findErrorNums(nums);
        System.out.println("Test Case 1: [" + result[0] + ", " + result[1] + "]"); // Output: [2, 3]
    }


}
