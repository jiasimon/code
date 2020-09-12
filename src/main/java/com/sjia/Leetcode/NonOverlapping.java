package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapping {
    // #435 https://leetcode.com/problems/non-overlapping-intervals/


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


}
