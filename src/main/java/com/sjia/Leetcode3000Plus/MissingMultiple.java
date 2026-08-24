package com.sjia.Leetcode3000Plus;

import com.sjia.Leetcode700.PrimeNumberSetBits;

import java.util.HashSet;
import java.util.Set;

public class MissingMultiple {
    // #3718. Smallest Missing Multiple of K  https://leetcode.com/problems/smallest-missing-multiple-of-k/description/
    /*
    Given an integer array nums and an integer k, return the smallest positive multiple of k that is missing from nums.

    A multiple of k is any positive integer divisible by k.
    Input: nums = [8,2,3,4,6], k = 2    Output: 10

    1 <= nums.length <= 100, 1 <= nums[i] <= 100 , 1 <= k <= 100
     */

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> tmp = new HashSet<>();
        for (int n : nums) {
            tmp.add(n);
        }
        for (int i=1; i<=100; i++ ) {
            if (!tmp.contains(i*k)) {
                return i*k;
            }

        }
        return 101*k;
    }

    public static void main(String[] args) {
        MissingMultiple solution = new MissingMultiple();

        // Test Case 1: 3 is the first missing multiple of 3
        int[] nums1 = {1, 2, 6, 9, 12};
        int result1 = solution.missingMultiple(nums1, 3);
        System.out.println("Test 1: Expected = 3, Actual = " + result1);

        // Test Case 2: 2 and 4 exist, 6 is missing
        int[] nums2 = {2, 4, 8, 10};
        int result2 = solution.missingMultiple(nums2, 2);
        System.out.println("Test 2: Expected = 6, Actual = " + result2);

        // Test Case 3: First multiple is missing
        int[] nums3 = {2, 3, 4, 5};
        int result3 = solution.missingMultiple(nums3, 5);
        System.out.println("Test 3: Expected = 5, Actual = " + result3);

        // Test Case 4: Duplicates should not affect the result
        int[] nums4 = {3, 3, 6, 6, 12};
        int result4 = solution.missingMultiple(nums4, 3);
        System.out.println("Test 4: Expected = 9, Actual = " + result4);

        // Test Case 5: Empty array
        int[] nums5 = {};
        int result5 = solution.missingMultiple(nums5, 4);
        System.out.println("Test 5: Expected = 4, Actual = " + result5);
    }
}
