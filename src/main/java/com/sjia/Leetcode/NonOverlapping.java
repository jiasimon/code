package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapping {
    // #435. Non-overlapping Intervals https://leetcode.com/problems/non-overlapping-intervals/

    /*
    Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

    Input: intervals = [[1,2],[2,3],[3,4],[1,3]]    Output: 1
    Input: intervals = [[1,2],[1,2],[1,2]]          Output: 2
    Input: intervals = [[1,2],[2,3]]                Output: 0

    1 <= intervals.length <= 10^5

     */

    // [1,2],[2,3],[-100,3],[3,4],[5,7]
    // [1,2],[2,3],[3,4],[1,3]


    // Runtime: 3 ms, faster than 68.10% of Java online submissions for Non-overlapping Intervals.
    //Memory Usage: 39.3 MB, less than 74.12% of Java online submissions for Non-overlapping Intervals.
    public int eraseOverlapIntervals_old(int[][] intervals) {
        int N = intervals.length;
        if ( N <= 1 ) return 0;
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(intervals, (a,b) -> a[1] -b[1]);
        int end = intervals[0][1];
        int count =1;
        for (int i=1; i<N; i++) {
            if( intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return N-count;

    }


    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by their end points
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int nonOverlapCount = 1; // At least one interval is non-overlapping
        int end = intervals[0][1]; // The end point of the first interval

        // Iterate through the intervals to find overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // No overlap, update the end point
                end = intervals[i][1];
                nonOverlapCount++;
            }
            // If there is an overlap, ignore the current interval
        }

        // Calculate the number of intervals to remove
        int toRemove = intervals.length - nonOverlapCount;
        return toRemove;
    }

    public static void main(String[] args) {
        NonOverlapping solution = new NonOverlapping();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int minRemovals = solution.eraseOverlapIntervals(intervals);
        System.out.println("Minimum Intervals to Remove: " + minRemovals); // Output: 1
    }




}
