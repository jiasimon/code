package com.sjia.Leetcode;

import java.util.*;

public class SmallestRangeCoveringElements {
    // #632. Smallest Range Covering Elements from K Lists  https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
    /*
    Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]    Output: [20,24]
    List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
    List 2: [0, 9, 12, 20], 20 is in range [20,24].
    List 3: [5, 18, 22, 30], 22 is in range [20,24].

     */


    // PriorityQueue, minHeap
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> nums.get(a[0]).get(a[1])));
        int max = Integer.MIN_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        // Initialize the min heap with the first element from each list
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        while (minHeap.size() == nums.size()) {
            int[] minIndex = minHeap.poll();
            int listIndex = minIndex[0];
            int elementIndex = minIndex[1];
            int currentRange = max - nums.get(listIndex).get(elementIndex);

            if (currentRange < rangeEnd - rangeStart || (currentRange == rangeEnd - rangeStart && nums.get(listIndex).get(elementIndex) < rangeStart)) {
                rangeStart = nums.get(listIndex).get(elementIndex);
                rangeEnd = max;
            }

            if (elementIndex + 1 < nums.get(listIndex).size()) {
                minHeap.offer(new int[]{listIndex, elementIndex + 1});
                max = Math.max(max, nums.get(listIndex).get(elementIndex + 1));
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }


    public static void main(String[] args) {
        SmallestRangeCoveringElements solution = new SmallestRangeCoveringElements();

        // Test Case
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        int[] result = solution.smallestRange(nums);
        System.out.println("Test Case 1: [" + result[0] + ", " + result[1] + "]"); // Output: [20, 24]
    }

}
