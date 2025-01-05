package com.sjia.Leetcode700;

import java.util.TreeMap;

public class MyCalendar3 {
    // #732. My Calendar III    https://leetcode.com/problems/my-calendar-iii/description/
    /*
Tracks the number of times an event overlaps with other events.
Returns the maximum number of concurrent events at any time after each booking.

Event Points:
    Treat each booking as two events: a start event (+1) and an end event (-1).

Use TreeMap:
    Store event points in a TreeMap, where keys are time points, and values represent the cumulative count of events starting or ending at that time.

Sweep Line Algorithm:
    Iterate through the sorted time points and calculate the running sum of events at any given time to find the maximum overlap.
     */

    private TreeMap<Integer, Integer> timeline;

    public MyCalendar3() {
        timeline = new TreeMap<>();

    }

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        // Decrement the count at the end time
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        int maxConcurrent = 0;
        int ongoing = 0;

        // Sweep through the timeline to find the maximum number of concurrent events
        for (int count : timeline.values()) {
            ongoing += count;
            maxConcurrent = Math.max(maxConcurrent, ongoing);
        }

        return maxConcurrent;

    }



    public static void main(String[] args) {
        MyCalendar3 myCalendar = new MyCalendar3();

        // Test Case 1
        System.out.println(myCalendar.book(10, 20)); // Output: 1
        System.out.println(myCalendar.book(50, 60)); // Output: 1
        System.out.println(myCalendar.book(10, 40)); // Output: 2
        System.out.println(myCalendar.book(5, 15));  // Output: 3
        System.out.println(myCalendar.book(5, 10));  // Output: 3
        System.out.println(myCalendar.book(25, 55)); // Output: 3
    }


}
