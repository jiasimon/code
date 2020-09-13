package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    // #253 https://leetcode.com/problems/meeting-rooms-ii/

    // Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    // find the minimum number of conference rooms required.

    // Input: [[0, 30],[5, 10],[15, 20]]


    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length <=1) return 1;
        Arrays.sort(intervals, (a,b) -> a[0] -b[0] );
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] row : intervals) {
            if( ! pq.isEmpty() && row[0] > pq.peek()) {
                pq.poll();
            }
            pq.offer(row[1]);
        }
        return pq.size();
    }




}
