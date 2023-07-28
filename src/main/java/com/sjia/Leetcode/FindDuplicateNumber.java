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
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for ( int n: nums) {
            if (!set.add(n)) return n;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        FindDuplicateNumber solution = new FindDuplicateNumber();
        int duplicate = solution.findDuplicate(nums);
        System.out.println("The duplicate number is: " + duplicate); // Output: The duplicate number is: 2
    }

}
