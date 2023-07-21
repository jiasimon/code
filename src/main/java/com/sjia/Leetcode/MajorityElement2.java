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
    public List<Integer> majorityElement(int[] nums) {
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



    // Test the code
    public static void main(String[] args) {
        MajorityElement2 solution = new MajorityElement2();

        int[] nums = {3, 2, 3}; // Output: [3]
        System.out.println(solution.majorityElement(nums));

        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2}; // Output: [1, 2]
        System.out.println(solution.majorityElement(nums2));
    }



}
