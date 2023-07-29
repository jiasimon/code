package com.sjia.Leetcode;

import java.util.PriorityQueue;

public class FindMedianInStream {
    // #295. Find Median from Data Stream   https://leetcode.com/problems/find-median-from-data-stream/
    /*
    The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

    For example, for arr = [2,3,4], the median is 3.
    For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
    Implement the MedianFinder class:

    MedianFinder() initializes the MedianFinder object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
     */


    /*
    use two priority queues: one max-heap to store the lower half of the data stream
    and one min-heap to store the upper half of the data stream.
    By maintaining these two heaps, we can efficiently find the median at any given point in time.
     */

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianInStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianInStream medianFinder = new FindMedianInStream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median = medianFinder.findMedian(); // Output: 1.5
        System.out.println("The median is: " + median);

        medianFinder.addNum(3);
        median = medianFinder.findMedian(); // Output: 2.0
        System.out.println("The median is: " + median);
    }


}
