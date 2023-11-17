package com.sjia.Leetcode;

import java.util.Arrays;

public class MinimizeMaxPairSum {
    // #1877. Minimize Maximum Pair Sum in Array
    // https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/?envType=daily-question&envId=2023-11-17

    /*
    The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.

    For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
    Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:

    Each element of nums is in exactly one pair, and
    The maximum pair sum is minimized.

    Input: nums = [3,5,2,3]     Output: 7

    nums = [3,5,4,2,4,6]        Output: 8

    2 <= n <= 100000
    n is even.
    1 <= nums[i] <= 100000

     */

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxPairSum = 0;

        int left = 0, right = n - 1;
        while (left < right) {
            maxPairSum = Math.max(maxPairSum, nums[left] + nums[right]);
            left++;
            right--;
        }

        return maxPairSum;
    }

    public static void main(String[] args) {
        MinimizeMaxPairSum solution = new MinimizeMaxPairSum();
        int[] nums = {3, 5, 2, 3};

        int minMaxPairSum = solution.minPairSum(nums);
        System.out.println("Minimum Maximum Pair Sum: " + minMaxPairSum);
    }


}
