package com.sjia.Leetcode;

import java.util.Stack;

public class Pattern132 {
    // #456. 132 Pattern    https://leetcode.com/problems/132-pattern/description/

    /*
    Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

    Return true if there is a 132 pattern in nums, otherwise, return false.

    Input: nums = [1,2,3,4]     Output: false
    Explanation: There is no 132 pattern in the sequence.

    Input: nums = [3,1,4,2]     Output: true
    Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

    Input: nums = [-1,3,2,0]    Output: true
    Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
     */


    // use a stack to keep track of potential 3 values
    // and a variable to keep track of the maximum 2 value encountered so far
    // 25 ms, 46.60%; 63.6 MB, 24.86%
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int max2 = Integer.MIN_VALUE; // Maximum value for '2' in '132' pattern

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < max2) {
                return true; // Found a '1' and '3' combination with '2' in between
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max2 = stack.pop(); // Update the maximum '2' value
            }

            stack.push(nums[i]);
        }

        return false; // No '132' pattern found
    }

    public static void main(String[] args) {
        Pattern132 solution = new Pattern132();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {3, 1, 4, 2};
        int[] nums3 = {-1, 3, 2, 0};

        System.out.println(solution.find132pattern(nums1)); // Output: false
        System.out.println(solution.find132pattern(nums2)); // Output: true
        System.out.println(solution.find132pattern(nums3)); // Output: true
    }


}
