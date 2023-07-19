package com.sjia.Leetcode;

import java.util.TreeSet;

public class ContainsDuplicate3 {
    // #220. Contains Duplicate III     https://leetcode.com/problems/contains-duplicate-iii/
    /*
    You are given an integer array nums and two integers indexDiff and valueDiff.

    Find a pair of indices (i, j) such that:

    i != j,
    abs(i - j) <= indexDiff.
    abs(nums[i] - nums[j]) <= valueDiff, and
    Return true if such pair exists or false otherwise.

    Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0   Output: true
    Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3   Output: false

    2 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    1 <= indexDiff <= nums.length
    0 <= valueDiff <= 10^9

     */


    // TreeSet
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();  // long for overflow
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t); // ceiling()：方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }



    public static void main(String[] args) {
        ContainsDuplicate3 solution = new ContainsDuplicate3();

        int[] nums1 = {1, 2, 3, 1}; // true, there are duplicates 1 (index 0) and 1 (index 3) with a difference of at most 3.
        System.out.println(solution.containsNearbyAlmostDuplicate(nums1, 3, 3));

        int[] nums2 = {1, 0, 1, 1}; // true, there are duplicates 1 (index 2) and 1 (index 3) with a difference of at most 1.
        System.out.println(solution.containsNearbyAlmostDuplicate(nums2, 1, 1));

        int[] nums3 = {1, 5, 9, 1, 5, 9}; // false, no duplicates with a difference of at most 2.
        System.out.println(solution.containsNearbyAlmostDuplicate(nums3, 2, 3));
    }

}
