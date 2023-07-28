package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    // #287. Find the Duplicate Number  https://leetcode.com/problems/find-the-duplicate-number/description/
    /*
    #forinterview
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

    There is only one repeated number in nums, return this repeated number.

    You must solve the problem without modifying the array nums and uses only constant extra space.

    Input: nums = [1,3,4,2,2]   Output: 2
    Input: nums = [3,1,3,4,2]   Output: 3

     */

    // HashSet !set.add(n)
    // 14 ms, 42.95%; 59.1 MB, 13.14%
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for ( int n: nums) {
            if (!set.add(n)) return n;
        }

        return -1;
    }


    // set.contains
    // 19 ms, 39.49%; 60.8 MB,6.11%
    public int findDuplicateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for ( int n: nums) {
            if (set.contains(n)) return n;
            else set.add(n);
        }

        return -1;
    }


    // brute
    public static int findDuplicate_2loops(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return len;
    }


    // count O(N)
    // 2 ms, 98.67%; 56.9 MB, 28.98%
    public static int findDuplicateByCount(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }




    // Mark visited negative, modify input
    // 3ms, 92.36%; 55.99mb, 97.76%
    public static int findDuplicateByMarkNegative(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int tmp = Math.abs(nums[i]);
            if(nums[tmp] < 0) {
                return tmp;
            }
            nums[tmp] = - nums[tmp];
        }

        return n;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        FindDuplicateNumber solution = new FindDuplicateNumber();
        int duplicate = solution.findDuplicateByMarkNegative(nums);
        System.out.println("The duplicate number is: " + duplicate); // Output: The duplicate number is: 2
    }

}
