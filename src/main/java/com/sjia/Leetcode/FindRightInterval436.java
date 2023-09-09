package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval436 {
    // #436. Find Right Interval    https://leetcode.com/problems/find-right-interval/description/

    /*
    You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

    The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

    Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

    Input: intervals = [[1,2]]      Output: [-1]
    Explanation: There is only one interval in the collection, so it outputs -1.

    Input: intervals = [[3,4],[2,3],[1,2]]  Output: [-1,0,1]
    Explanation: There is no right interval for [3,4].
    The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
    The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.

    Input: intervals = [[1,4],[2,3],[3,4]]  Output: [-1,2,-1]

    1 <= intervals.length <= 2 * 10^4
    -10^6 <= starti <= endi <= 10^6
     */

    class IntervalWithIndex {
        int[] interval;
        int index;

        IntervalWithIndex(int[] interval, int index) {
            this.interval = interval;
            this.index = index;
        }
    }



    // interval with index, binary search, l<=r
    // 11 ms, 86.49%; 46.8 MB, 73.18%
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        IntervalWithIndex[] intervalsWithIndex = new IntervalWithIndex[n];

        // Create custom data structures to store the original interval and its index
        for (int i = 0; i < n; i++) {
            intervalsWithIndex[i] = new IntervalWithIndex(intervals[i], i);
        }

        // Sort intervals by their start times
        Arrays.sort(intervalsWithIndex, Comparator.comparingInt(a -> a.interval[0]));

        for (int i = 0; i < n; i++) {
            int targetStart = intervals[i][1];
            int left = 0;
            int right = n - 1;
            int rightIntervalIndex = -1;

            // Perform binary search to find the right interval
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (intervalsWithIndex[mid].interval[0] >= targetStart) {
                    rightIntervalIndex = intervalsWithIndex[mid].index;
                    right = mid - 1; // Continue searching in the left half
                } else {
                    left = mid + 1; // Continue searching in the right half
                }
            }

            result[i] = rightIntervalIndex;
        }

        return result;
    }

    public static void main(String[] args) {
        FindRightInterval436 solution = new FindRightInterval436();
        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        int[] rightIntervals = solution.findRightInterval(intervals);
        System.out.println("Right Intervals: " + Arrays.toString(rightIntervals)); // Output: [1, 0, -1]
    }

}
