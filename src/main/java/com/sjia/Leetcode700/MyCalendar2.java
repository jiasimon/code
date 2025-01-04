package com.sjia.Leetcode700;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar2 {
    // #731. My Calendar II     https://leetcode.com/problems/my-calendar-ii/description/
    /*
Use two lists:

    bookings: Store all single bookings.
    overlaps: Store all double bookings.

Check for Overlap:

    A new event overlaps an existing one if start < existingEnd && end > existingStart.

Double Booking:

    If the new event overlaps with any double booking, reject the booking.

Update Bookings:

    For all overlaps with single bookings, add the overlapping interval to overlaps.
     */

    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendar2() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check if the new event overlaps with any double booking
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false; // Triple booking detected
            }
        }

        // Check for overlaps with single bookings and add to overlaps
        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                // Add the overlapping interval to overlaps
                overlaps.add(new int[]{Math.max(start, booking[0]), Math.min(end, booking[1])});
            }
        }

        // Add the new event to single bookings
        bookings.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar2 myCalendar = new MyCalendar2();

        // Test Case 1
        System.out.println(myCalendar.book(10, 20)); // Output: true
        System.out.println(myCalendar.book(50, 60)); // Output: true
        System.out.println(myCalendar.book(10, 40)); // Output: true
        System.out.println(myCalendar.book(5, 15));  // Output: false
        System.out.println(myCalendar.book(5, 10));  // Output: true
        System.out.println(myCalendar.book(25, 55)); // Output: true
    }


}
