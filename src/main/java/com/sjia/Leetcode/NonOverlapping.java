package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapping {
    // #435 https://leetcode.com/problems/non-overlapping-intervals/

    // [1,2],[2,3],[-100,3],[3,4],[5,7]
    // [1,2],[2,3],[3,4],[1,3]


    // Runtime: 3 ms, faster than 68.10% of Java online submissions for Non-overlapping Intervals.
    //Memory Usage: 39.3 MB, less than 74.12% of Java online submissions for Non-overlapping Intervals.
    public int eraseOverlapIntervals(int[][] intervals) {
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


    // Runtime: 12 ms
    // Memory Usage: 42.2 MB
/*
    public int eraseOverlapIntervals(int[][] intervals) {
        if ( intervals.length == 0 ) return 0;
         Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        // Arrays.sort(intervals, (a,b) -> a[1] -b[1]);
        int end = intervals[0][1];
        int count =1;
        for (int i=1; i < intervals.length; i++) {
            if( intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;

    }*/


}
