package com.sjia.Leetcode700;

import java.util.PriorityQueue;

public class KthLargestElement {
    // #703. Kth Largest Element in a Stream    https://leetcode.com/problems/kth-largest-element-in-a-stream/description/


    private final PriorityQueue<Integer> minHeap;
    private final int k;


    public KthLargestElement(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Add elements to the min-heap and maintain the size to k.
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);  // Add the new element
        if (minHeap.size() > k) {
            minHeap.poll();  // Remove the smallest element if size exceeds k
        }
        return minHeap.peek();  // The root of the heap is the k-th largest element
    }

    public static void main(String[] args) {
        // Test Case: Initialize with k = 3 and stream = [4, 5, 8, 2]
        int k = 3;
        int[] stream = {4, 5, 8, 2};
        KthLargestElement kthLargest = new KthLargestElement(k, stream);

        // Add new elements and print the k-th largest element after each insertion
        System.out.println(kthLargest.add(3));  // Output: 4
        System.out.println(kthLargest.add(5));  // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9));  // Output: 8
        System.out.println(kthLargest.add(4));  // Output: 8
    }

}
