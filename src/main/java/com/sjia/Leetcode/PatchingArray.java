package com.sjia.Leetcode;

public class PatchingArray {
    // #330. Patching Array     https://leetcode.com/problems/patching-array/
    /*
    Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.

    Return the minimum number of patches required.

    Input: nums = [1,3], n = 6
    Output: 1
    Explanation:
    Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
    Now if we add/patch 2 to nums,

    1 <= nums.length <= 1000
    1 <= nums[i] <= 10000
    1 <= n <= 2^31 - 1
     */


    public int minPatches2(int[] nums, int n) {
        int count = 0;
        long miss = 1; // Represents the smallest sum that cannot be obtained using the numbers seen so far
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // If the current number can be used to extend the range, update the 'miss' value
                miss += nums[i];
                i++;
            } else {
                // If the current number cannot be used, add 'miss' to the array and update the 'miss' value
                miss += miss;
                count++;
            }
        }

        return count;
    }


    // 0ms, 100%; 42.80mb, 91.57%
    public int minPatches(int[] nums, int n) {
        int res =0;
        int i = 0; // nums array index
        long miss = 1; // Min sum we may miss

        while(miss <= n ) {
            if( i < nums.length && nums[i] <= miss) {
                miss = miss + nums[i];
                i++;
            } else {
                miss += miss;
                res++;
            }

        }
        return res;

    }


    public static void main(String[] args) {
        PatchingArray solution = new PatchingArray();
        int[] nums = {1, 3};
        int n = 6;
        System.out.println(solution.minPatches(nums, n)); // Output: 1 (Add 2 to the array: [1, 3, 2] covers the range 1 to 6)

        int[] nums2 = {1, 5, 10};
        n = 20;
        System.out.println(solution.minPatches(nums2, n));

    }

}
