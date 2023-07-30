package com.sjia.Leetcode;

public class MeetingRooms {
    // #252. Meeting Rooms https://leetcode.com/problems/meeting-rooms/
    // https://grandyang.com/leetcode/252/

    /*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    determine if a person could attend all meetings.
    Input: [[0,30],[5,10],[15,20]]  Output: false
    Input: [[7,10],[2,4]]           Output: true

     */


    // brute force
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i=0; i < intervals.length; i++) {
            for (int j= i+1; j < intervals.length; j++ ) {
                if ( intervals[i][0] >= intervals[j][0] && intervals[i][0] < intervals[j][1]
                || intervals[j][0] >= intervals[i][0] && intervals[j][0]  < intervals[i][1] ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        MeetingRooms solution = new MeetingRooms();
        boolean result = solution.canAttendMeetings(intervals);
        System.out.println("Can attend all meetings? " + result); // Output: Can attend all meetings? false
    }


}
