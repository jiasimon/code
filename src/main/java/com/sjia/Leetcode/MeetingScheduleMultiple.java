package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class MeetingScheduleMultiple {

    // Karat

    /*
We are writing a tool to help users manage their calendars. Given an unordered list of times of day when people are busy, write a function that tells us the intervals during the day when ALL of them are available.

Each time is expressed as an integer using 24-hour notation, such as 1200 (12:00), 1530 (15:30), or 800 (8:00).

Sample input:

p1_meetings = [
  (1230, 1300),
  ( 845, 900),
  (1300, 1500),
]

p2_meetings = [
  ( 0, 844),
  ( 930, 1200),
  (1515, 1546),
  (1600, 2400),
]

p3_meetings = [
  ( 845, 915),
  (1515, 1545),
  (1235, 1245),
]

  ( 845, 900),
  ( 845, 915),
  (1230, 1300),
  (1235, 1245),
  (1300, 1500),
  (1515, 1545),



schedules1 = [p1_meetings, p2_meetings, p3_meetings]
schedules2 = [p1_meetings, p3_meetings]

Expected output:

findAvailableTimes(schedules1)
 => [  844,  845 ],
    [  915,  930 ],
    [ 1200, 1230 ],
    [ 1500, 1515 ],
    [ 1546, 1600 ]

findAvailableTimes(schedules2)
 => [    0,  845 ],
    [  915, 1230 ],
    [ 1500, 1515 ],
    [ 1545, 2400 ]

*/


    public  static int[][] findAvailableTimes(List<int[][] > input) {
        List< int[] > res = new ArrayList<>();

        List <int[]> entry = new ArrayList<>();
        for (int[][] ent: input){
            for ( int[] row : ent )
                entry.add(row);
        }
        System.out.println(Arrays.deepToString(entry.toArray()));

        Collections.sort(entry, (a, b) -> a[0] -b[0]);

        System.out.println(Arrays.deepToString(entry.toArray()));

        int startTime = -1, endTime = 0;
        // if ( entry.get(0)[0] !=0) res.add( new int[] {0, entry.get(0)[0] });
        for (int i=0 ; i< entry.size(); i++) {
            System.out.println("startTime is: " + startTime + ", endTime is: " + endTime);
            if (entry.get(i)[0] > endTime ) {
                res.add(new int[] {endTime, entry.get(i)[0]});
                startTime = entry.get(i)[0];
                endTime = Math.max(endTime, entry.get(i)[1]);
            } else {
                endTime = Math.max(endTime, entry.get(i)[1]);
            }
        }
        if (entry.get(entry.size()-1)[1] < 2400) res.add(new int[] {entry.get(entry.size()-1)[1], 2400});
        System.out.println(Arrays.deepToString(res.toArray()));

        return res.toArray(new int[0][]);
    }


    public static void main(String[] argv) {
        int[][] p1Meetings = {
/*       {845, 900} ,
      {845, 915} ,
      {1230, 1300},
      {1235, 1245},
      {1300, 1500},
      {1515, 1545}      */
                {1230, 1300},
                { 845,  900},
                {1300, 1500}
        };
        int[][] p2Meetings = {
                { 0, 844},
                { 930, 1200},
                {1515, 1546},
                {1600, 2400}
        };
        int[][] p3Meetings = {
                { 845,  915},
                {1515, 1545},
                {1235, 1245}
        };

        List<int[][]> schedules1 = Arrays.asList(p1Meetings, p2Meetings, p3Meetings);
        List<int[][]> schedules2 = Arrays.asList(p1Meetings, p3Meetings);
        List<int[][]> schedules3 = new ArrayList<>();
        schedules3.add(p1Meetings);
        findAvailableTimes(schedules2);


    }

}
