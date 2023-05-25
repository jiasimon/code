package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    // #56. Merge Intervals  https://leetcode.com/problems/merge-intervals/ #fb

    // 1 <= intervals.length <= 10^4 , intervals[i].length == 2
    // 0 <= starti <= endi <= 104

    // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]  [[1,6],[8,10],[15,18]]
    // Input: intervals = [[1,4],[4,5]]  [[1,5]]




    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }





    // res.toArray(new int[res.size()][])
    // sort (a, b) -> a[0] -b[0]
    // Runtime: 5 ms, faster than 94.24% of Java online submissions for Merge Intervals.
    // Memory Usage: 41.6 MB, less than 66.18% of Java online submissions for Merge Intervals.
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <=1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] -b[0]);
        List<int[]> res = new ArrayList<>();

        int[] tmp = intervals[0];
        res.add(tmp);
        for (int[] in : intervals)  {
            if(in[0] <= tmp[1]) {
                tmp[1] = Math.max(in[1], tmp[1]);
            } else {
                tmp = in;
                res.add(tmp);
            }
        }

        return res.toArray(new int[res.size()][]);

    }


    public static void main(String[] args) {
        // init values for int[][]
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
        // Output: [1, 6], [8, 10], [15, 18]

        // Arrays.deepToString output two dimensional array
        System.out.println(Arrays.deepToString(mergedIntervals));
        // Output:   [[1, 6], [8, 10], [15, 18]]

    }



}
