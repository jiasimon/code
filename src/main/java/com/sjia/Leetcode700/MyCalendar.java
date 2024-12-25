package com.sjia.Leetcode700;

import java.util.TreeMap;

public class MyCalendar {
    // #729. My Calendar I  https://leetcode.com/problems/my-calendar-i/description/
    /*
Use a sorted data structure to store intervals.

For every new event, check if it overlaps with any existing event.

Overlap condition:

    A new event [start, end) overlaps an existing event [s, e) if start < e && end > s.

If no overlap is found, add the new event to the calendar.
     */

    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Find the previous and next events
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);

        // Check for overlap with the previous event
        if (prev != null && calendar.get(prev) > start) {
            return false;
        }

        // Check for overlap with the next event
        if (next != null && next < end) {
            return false;
        }

        // No overlap, add the event
        calendar.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();

        // Test Case 1
        System.out.println(myCalendar.book(10, 20)); // Output: true
        System.out.println(myCalendar.book(15, 25)); // Output: false
        System.out.println(myCalendar.book(20, 30)); // Output: true

        // Test Case 2
        MyCalendar myCalendar2 = new MyCalendar();
        System.out.println(myCalendar2.book(5, 10)); // Output: true
        System.out.println(myCalendar2.book(10, 15)); // Output: true
        System.out.println(myCalendar2.book(8, 12)); // Output: false
    }

}
