package com.sjia.Leetcode600;

import java.util.HashMap;
import java.util.Map;

public class DegreeofArray {
    // #697. Degree of an Array     https://leetcode.com/problems/degree-of-an-array/description/
    /*
    Input: nums = [1,2,2,3,1]       Output: 2
    The input array has a degree of 2 because both elements 1 and 2 appear twice.
    Of the subarrays that have the same degree:
    [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
    The shortest length is 2. So return 2.

    Input: nums = [1,2,2,3,1,4,2]   Output: 6
    The degree is 3 because the element 2 is repeated 3 times.
    So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6
     */


    public int findShortestSubArray(int[] nums) {
        // Map to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Map to store the first occurrence index of each element
        Map<Integer, Integer> firstOccurrenceMap = new HashMap<>();
        // Map to store the last occurrence index of each element
        Map<Integer, Integer> lastOccurrenceMap = new HashMap<>();

        int degree = 0;

        // Populate the maps and calculate the degree of the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            if (!firstOccurrenceMap.containsKey(num)) {
                firstOccurrenceMap.put(num, i);
            }
            lastOccurrenceMap.put(num, i);
            degree = Math.max(degree, frequencyMap.get(num));  // Track the maximum frequency (degree)
        }

        int minLength = nums.length;

        // Find the shortest subarray with the same degree
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == degree) {
                int length = lastOccurrenceMap.get(num) - firstOccurrenceMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        DegreeofArray solution = new DegreeofArray();

        // Test case 1
        int[] nums1 = {1, 2, 2, 3, 1};
        System.out.println("Test case 1: " + solution.findShortestSubArray(nums1));  // Expected output: 2

        // Test case 2
        int[] nums2 = {1, 2, 2, 3, 1, 4, 2};
        System.out.println("Test case 2: " + solution.findShortestSubArray(nums2));  // Expected output: 6

        // Test case 3
        int[] nums3 = {1, 1, 1, 1};
        System.out.println("Test case 3: " + solution.findShortestSubArray(nums3));  // Expected output: 4

        // Test case 4
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println("Test case 4: " + solution.findShortestSubArray(nums4));  // Expected output: 1

        // Test case 5
        int[] nums5 = {1, 2, 1, 3, 1, 4, 1, 5};
        System.out.println("Test case 5: " + solution.findShortestSubArray(nums5));  // Expected output: 7
    }


}
