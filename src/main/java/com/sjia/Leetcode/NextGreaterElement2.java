package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement2 {
    // #503. Next Greater Element II    https://leetcode.com/problems/next-greater-element-ii/

    /*
    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

    The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

    Input: nums = [1,2,1]       Output: [2,-1,2]
    Input: nums = [1,2,3,4,3]   Output: [2,3,4,-1,4]

    1 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
     */


    // ArrayDeque, stack
    // 3 ms, 99.34%; 44.9 MB, 49.70%
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        // For a circular array, we iterate through the array twice
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement2 solution = new NextGreaterElement2();

        int[] nums = {1, 2, 1};

        int[] nextGreater = solution.nextGreaterElements(nums);
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreater));
    }


}
