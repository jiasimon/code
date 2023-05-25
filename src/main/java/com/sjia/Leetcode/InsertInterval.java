package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    // #57. Insert Interval  https://leetcode.com/problems/insert-interval/

    /*
    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

    Return intervals after the insertion.
     */

    // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]  Output: [[1,5],[6,9]]
    // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]  Output: [[1,2],[3,10],[12,16]]


    // 3 while, before , overlap, remaining
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i=0;
        int n = intervals.length;

        //  Add intervals which end before the new interval
        while ( i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // when iterate item startTime <= newInterval EndTime
        while ( i < n && intervals[i][0] <= newInterval[1]) {
            // below changed the newInterval input
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][2] );

//        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals0 = {{1, 3}, {2, 4}};  // output: [[1, 5]]
        int[][] intervals = {{1, 3}, {6, 9}}; // Output: [1, 5], [6, 9]
        int[] newInterval = {2, 5};
        int[][] mergedIntervals = insert(intervals, newInterval);

        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }


        System.out.println( "After InsertInterval: " + Arrays.deepToString(mergedIntervals));

    }




}
