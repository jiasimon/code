package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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


    // HashSet, contains(num - 1)
    // 464 ms, 15.31% ; 62.8 MB, 7.4%
    public int longestConsecutiveHashSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 0;

        for (int num : nums) {  // this caused slow running
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                res = Math.max(res, currentStreak);
            }
        }
        return res;
    }


    // better hashset solution
    // 34 ms , 68.56% ; 56 MB, 90.5%
    public int longestConsecutiveHashSet2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int best = 0;
        for(int n : set) {  // remove duplicates , increase performance
            if(!set.contains(n - 1)) {  // only check for one direction
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;

    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // Test case
        int[] nums = {100, 4, 200, 1,1, 3,3, 2};
        int result = solution.longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence: " + result);  // Output: 4

        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int result2 = solution.longestConsecutiveHashSet(nums2);
        System.out.println("Longest Consecutive Sequence: " + result2);  // Output: 9


        int[] nums3 = {0,3,7,2,5,8,4,6,0,10};
        int result3 = solution.longestConsecutive(nums3);
        System.out.println("Longest Consecutive Sequence: " + result3);  // Output: 7

        int[] nums4 = {2,1};
        int result4 = solution.longestConsecutiveHashSet(nums4);
        System.out.println("Longest Consecutive Sequence: " + result4);  // Output: 7

    }


}
