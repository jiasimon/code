package com.sjia.Leetcode700;

public class LargestNumberTwiceOthers {
    // #747. Largest Number At Least Twice of Others    https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
    /*
    Input: nums = [3,6,1,0]     Output: 1
    Input: nums = [1,2,3,4]     Output: -1
    2 <= nums.length <= 50
    0 <= nums[i] <= 100
    The largest element in nums is unique.
     */

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0; // Only one element, it's dominant.
        }

        int maxIndex = 0;
        int max = nums[0];
        int secondMax = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        // Check the "at least twice" condition
        if (max >= 2 * secondMax) {
            return maxIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LargestNumberTwiceOthers solution = new LargestNumberTwiceOthers();

        int[] nums1 = {3, 6, 1, 0};
        System.out.println(solution.dominantIndex(nums1));  // Output: 1

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.dominantIndex(nums2));  // Output: -1

        int[] nums3 = {1};
        System.out.println(solution.dominantIndex(nums3));  // Output: 0
    }



}
