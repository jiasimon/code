package com.sjia.Leetcode;

import java.util.Random;

public class RandomPickIndex {
    // #398. Random Pick Index  https://leetcode.com/problems/random-pick-index/description/

    /*
    Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

    Implement the Solution class:

    Solution(int[] nums) Initializes the object with the array nums.
    int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should have an equal probability of returning.

    1 <= nums.length <= 2 * 10^4
    -2^31 <= nums[i] <= 2^31 - 1
     */



    // 1365 ms, 21.88%; 55.9 MB, 26.66%
    class Solution {

        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();

        }

        public int pick(int target) {
            int count = 0;
            int result = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;
                    if (random.nextInt(count) == 0) {
                        result = i;
                    }
                }
            }

            return result;

        }
    }



}
