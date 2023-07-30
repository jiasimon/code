package com.sjia.Leetcode;

import java.util.Arrays;

public class MeetingRoom {
    // #252. Meeting Rooms https://leetcode.com/problems/meeting-rooms/
    /*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    determine if a person could attend all meetings.
    Input: [[0,30],[5,10],[15,20]]  Output: false
    Input: [[7,10],[2,4]]           Output: true
     */


    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        for (int i = 1 ; i< intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }





}
