package com.sjia.Leetcode;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    // #128. Longest Consecutive Sequence  https://leetcode.com/problems/longest-consecutive-sequence/
    /*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

    You must write an algorithm that runs in O(n) time.

    Input: nums = [100,4,200,1,3,2] Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Input: nums = [0,3,7,2,5,8,4,6,0,1] Output: 9

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
     */


    // Arrays.sort
    // Runtime 15 ms, 91.20%; Memory 56.9 MB, 69.65%
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);  // O(nlgn)

        int res = 1;
        int current = nums[0], count = 1;
        for (int i=1; i < nums.length; i++ ) {
            if (nums[i] == nums[i-1]) continue;
            if (nums[i] == nums[i-1] + 1) {
                count++;
            } else {
                res = Math.max(res, count);
                current = nums[i];
                count = 1;
            }
        }
        return Math.max(res, count);

    }


    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // Test case
//        int[] nums = {100, 4, 200, 1,1, 3,3, 2};
//        int result = solution.longestConsecutive(nums);
//        System.out.println("Longest Consecutive Sequence: " + result);  // Output: 4

        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int result2 = solution.longestConsecutive(nums2);
        System.out.println("Longest Consecutive Sequence: " + result2);  // Output: 9


        int[] nums3 = {0,3,7,2,5,8,4,6,0,10};
        int result3 = solution.longestConsecutive(nums3);
        System.out.println("Longest Consecutive Sequence: " + result3);  // Output: 7

    }


}
