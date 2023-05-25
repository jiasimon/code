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







    // Runtime: 5 ms, faster than 96.05% of Java online submissions for Merge Intervals.
    //Memory Usage: 42.4 MB, less than 40.86% of Java online submissions for Merge Intervals.
/*    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int N = intervals.length, min = intervals[0][0], max = intervals[0][1];
        for (int i = 1; i < N; i++) {
            if (intervals[i][0] > max) {
                int[] tmp = new int[] {min, max};
                result.add(tmp);
                min = intervals[i][0];
                max = intervals[i][1];
                if (i == N-1) {
                    int[] tmp2 = new int[] {min, max};
                    result.add(tmp2);
                }
            } else {
                max = Math.max (max, intervals[i][1]); // [[1,4],[2,3]]
                if (i == N-1) {
                    int[] tmp = new int[] {min, max};
                    result.add(tmp);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }*/




    // [1,3],[2,6]
    // [1,4],[4,5]
    // [1,6], [2,4]
    // [1,3], [5,8]


    // res.toArray(new int[res.size()][])
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
