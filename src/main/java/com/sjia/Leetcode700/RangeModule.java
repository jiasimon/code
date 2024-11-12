package com.sjia.Leetcode700;

import java.util.Map;
import java.util.TreeMap;

public class RangeModule {
    // #715. Range Module   https://leetcode.com/problems/range-module/description/
    /*

     */

    private TreeMap<Integer, Integer> intervals;

    public RangeModule() {
        intervals = new TreeMap<>();
    }

    // Adds the interval [left, right)
    public void addRange(int left, int right) {
        if (left >= right) return;

        // Find the interval that starts just before or overlaps with the current range
        Map.Entry<Integer, Integer> start = intervals.floorEntry(left);
        if (start != null && start.getValue() >= left) {
            left = start.getKey();
            right = Math.max(right, start.getValue());
            intervals.remove(start.getKey());
        }

        // Merge all overlapping intervals
        Map.Entry<Integer, Integer> next = intervals.ceilingEntry(left);
        while (next != null && next.getKey() <= right) {
            right = Math.max(right, next.getValue());
            intervals.remove(next.getKey());
            next = intervals.ceilingEntry(left);
        }

        // Insert the merged interval
        intervals.put(left, right);
    }

    // Removes the interval [left, right)
    public void removeRange(int left, int right) {
        if (left >= right) return;

        // Find the interval that starts just before or overlaps with the current range
        Map.Entry<Integer, Integer> start = intervals.floorEntry(left);
        if (start != null && start.getValue() > left) {
            int prevStart = start.getKey();
            int prevEnd = start.getValue();
            intervals.remove(prevStart);
            if (prevStart < left) {
                intervals.put(prevStart, left);
            }
            if (prevEnd > right) {
                intervals.put(right, prevEnd);
            }
        }

        // Remove all overlapping intervals
        Map.Entry<Integer, Integer> next = intervals.ceilingEntry(left);
        while (next != null && next.getKey() < right) {
            int nextEnd = next.getValue();
            intervals.remove(next.getKey());
            if (nextEnd > right) {
                intervals.put(right, nextEnd);
                break;
            }
            next = intervals.ceilingEntry(left);
        }
    }

    // Checks if the interval [left, right) is fully covered
    public boolean queryRange(int left, int right) {
        if (left >= right) return false;

        // Find the interval that starts just before or overlaps with the current range
        Map.Entry<Integer, Integer> start = intervals.floorEntry(left);
        return start != null && start.getValue() >= right;
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();

        // Test Case 1
        rangeModule.addRange(10, 20);
        System.out.println(rangeModule.queryRange(10, 14)); // Output: true
        System.out.println(rangeModule.queryRange(13, 15)); // Output: true
        System.out.println(rangeModule.queryRange(15, 17)); // Output: true

        // Test Case 2
        rangeModule.addRange(16, 22);
        System.out.println(rangeModule.queryRange(17, 21)); // Output: true

        // Test Case 3
        rangeModule.removeRange(14, 18);
        System.out.println(rangeModule.queryRange(13, 15)); // Output: false
        System.out.println(rangeModule.queryRange(18, 20)); // Output: true
    }
}
