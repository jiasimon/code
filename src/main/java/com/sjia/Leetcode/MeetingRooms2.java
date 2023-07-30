package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    // #253. Meeting Rooms II https://leetcode.com/problems/meeting-rooms-ii/
    /*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    find the minimum number of conference rooms required.

    https://grandyang.com/leetcode/253/

    Input: [[0, 30],[5, 10],[15, 20]]   Output: 2
    Input: [[7,10],[2,4]]       Output: 1

     */



    // Input: [[0, 30],[5, 10],[15, 20]]


    // PriorityQueue
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



    public static void main(String[] args) {
        int[][] testData  =  { {0, 30}, {5, 10}, {15, 20}  };
        MeetingRooms2 solution = new MeetingRooms2();
        int result = solution.minMeetingRooms(testData);

        System.out.printf("testData %s minimum number meeting room is %s \n",
                Arrays.deepToString(testData),result);
    }

}
