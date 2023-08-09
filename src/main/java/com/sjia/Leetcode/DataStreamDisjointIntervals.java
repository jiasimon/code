package com.sjia.Leetcode;

import java.util.*;

public class DataStreamDisjointIntervals {
    // #352. Data Stream as Disjoint Intervals  https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/
    /*
    Implement the SummaryRanges class:

    SummaryRanges() Initializes the object with an empty stream.
    void addNum(int value) Adds the integer value to the stream.
    int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.

    0 <= value <= 10000

     */

    private List<int[]> intervals;

    public DataStreamDisjointIntervals() {
        intervals = new ArrayList<>();
    }


    // 23ms, 48.30%; 43.52mb, 91.95%
    public void addNum(int value) {
        if (intervals.isEmpty()) {
            intervals.add(new int[] { value, value });
            return;
        }

        int index = 0;
        while (index < intervals.size() && intervals.get(index)[1] < value) {
            index++;
        }

        if (index < intervals.size() && intervals.get(index)[0] <= value) {
            return; // Already in an interval
        }

        boolean mergePrev = index > 0 && intervals.get(index - 1)[1] + 1 == value;
        boolean mergeNext = index < intervals.size() && intervals.get(index)[0] - 1 == value;

        if (mergePrev && mergeNext) {
            intervals.get(index - 1)[1] = intervals.get(index)[1];
            intervals.remove(index);
        } else if (mergePrev) {
            intervals.get(index - 1)[1] = value;
        } else if (mergeNext) {
            intervals.get(index)[0] = value;
        } else {
            intervals.add(index, new int[] { value, value });
        }
    }

    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        for (int i = 0; i < intervals.size(); i++) {
            result[i] = intervals.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        DataStreamDisjointIntervals summaryRanges = new DataStreamDisjointIntervals();
        summaryRanges.addNum(1);
        summaryRanges.addNum(3);
        summaryRanges.addNum(7);
        summaryRanges.addNum(2);
        summaryRanges.addNum(6);
        int[][] intervals = summaryRanges.getIntervals();
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }


}
