package com.sjia.Leetcode;

import java.util.*;
import java.util.function.Supplier;

public class SlidingWindowMedian480 {
    // #480. Sliding Window Median      https://leetcode.com/problems/sliding-window-median/

    /*
    You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

    Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.

    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3    Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
    Explanation:
    Window position                Median
    ---------------                -----
    [1  3  -1] -3  5  3  6  7        1
     1 [3  -1  -3] 5  3  6  7       -1
     1  3 [-1  -3  5] 3  6  7       -1
     1  3  -1 [-3  5  3] 6  7        3
     1  3  -1  -3 [5  3  6] 7        5
     1  3  -1  -3  5 [3  6  7]       6

    Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
    Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]

    1 <= k <= nums.length <= 10^5
    -2^31 <= nums[i] <= 2^31 - 1
     */


    /*
    40 / 43 testcases passed

    nums =
    [9,7,0,3,9,8,6,5,7,6]
    k =
    2
    Use Testcase
    Output
    [8.00000,3.50000,1.50000,6.00000,6.00000,5.50000,4.50000,6.00000,6.50000]
    Expected
    [8.00000,3.50000,1.50000,6.00000,8.50000,7.00000,5.50000,6.00000,6.50000]

     */

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> result = new ArrayList<>();
        TreeSet<Integer> maxHeap = new TreeSet<>((a, b) -> nums[b] != nums[a] ? Integer.compare(nums[b], nums[a]) : a - b);
        TreeSet<Integer> minHeap = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b);

        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || nums[i] <= nums[maxHeap.first()]) {
                maxHeap.add(i);
            } else {
                minHeap.add(i);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.pollFirst());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.pollFirst());
            }

            if (i >= k - 1) {
                if (k % 2 == 0) {
                    result.add((nums[maxHeap.first()] / 2.0) + (nums[minHeap.first()] / 2.0));
                } else {
                    result.add((double) nums[maxHeap.first()]);
                }

                int toBeRemoved = nums[i - k + 1];
                if (!maxHeap.isEmpty() && toBeRemoved <= nums[maxHeap.first()]) {
                    maxHeap.remove(i - k + 1);
                } else {
                    minHeap.remove(i - k + 1);
                }
            }
        }

        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }



    // two Tree Sets

    public double[] medianSlidingWindow_twoTreeSet(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        Supplier<Double> median = (k % 2 == 0) ?
                () -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
                () -> (double) nums[right.first()];

        // balance lefts size and rights size (if not equal then right will be larger by one)
        Runnable balance = () -> { while (left.size() > right.size()) right.add(left.pollFirst()); };

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) left.add(i);
        balance.run(); result[0] = median.get();

        for (int i = k, r = 1; i < nums.length; i++, r++) {
            // remove tail of window from either left or right
            if(!left.remove(i - k)) right.remove(i - k);
// add next num, this will always increase left size
            right.add(i); left.add(right.pollFirst());

            // rebalance left and right, then get median from them
            balance.run(); result[r] = median.get();
        }

        return result;
    }



    public static void main(String[] args) {
        SlidingWindowMedian480 solution = new SlidingWindowMedian480();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        double[] medians = solution.medianSlidingWindow(nums, k);
        System.out.println("Sliding Window Medians: " + Arrays.toString(medians));
    }


}
