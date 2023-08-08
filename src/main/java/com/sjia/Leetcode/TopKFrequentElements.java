package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    // #347. Top K Frequent Elements    https://leetcode.com/problems/top-k-frequent-elements/
    /*
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    Input: nums = [1,1,1,2,2,3], k = 2  Output: [1,2]
    Input: nums = [1], k = 1        Output: [1]
     */



    // PriorityQueue
    public int[] topKFrequent(int[] nums, int k) {
        // Create a frequency map to count the occurrences of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a min-heap (priority queue) to store the top k frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        // Add elements to the min-heap while keeping only the top k elements
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Convert the min-heap to an array and reverse it to get the elements in descending order of frequency
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }

}
