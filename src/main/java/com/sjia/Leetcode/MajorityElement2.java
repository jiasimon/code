package com.sjia.Leetcode;

import java.util.*;

public class MajorityElement2 {
    // #229. Majority Element II    https://leetcode.com/problems/majority-element-ii/
    /*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    Input: nums = [3,2,3]   Output: [3]
    Input: nums = [1]   Output: [1]
    Input: nums = [1,2] Output: [1,2]
    1 <= nums.length <= 5 * 10^4
    -10^9 <= nums[i] <= 10^9

     */

    // HashMap, HashSet
    // 13ms, 33.37%; 46.54mb; 72.40%
    public List<Integer> majorityElement2(int[] nums) {
        int total = nums.length;
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n,0) + 1;
            map.put(n, count);
            if (count > total/3) {
                result.add(n);
            }
        }
        return new ArrayList<>(result) ;
    }



    // Boyer-Moore Voting
    // 2ms 97.97%; 47.39mb, 5.36%
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        // Initialize two candidate numbers and their corresponding counts
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;

        // Voting process
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Count occurrences of the candidates to determine if they are majority elements
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Add the majority elements to the result list
        int n = nums.length;
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        return result;
    }

    // Test the code
    public static void main(String[] args) {
        MajorityElement2 solution = new MajorityElement2();

        int[] nums = {3, 2, 3}; // Output: [3]
        System.out.println(solution.majorityElement(nums));

        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2}; // Output: [1, 2]
        System.out.println(solution.majorityElement(nums2));
    }



}
