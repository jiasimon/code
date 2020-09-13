package com.sjia.Leetcode;

import java.util.Arrays;

public class MeetingRoom {
    // #252 https://leetcode.com/problems/meeting-rooms/


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
