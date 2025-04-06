package com.sjia.Leetcode700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetIntersectionSize {
    // #757. Set Intersection Size At Least Two     https://leetcode.com/problems/set-intersection-size-at-least-two/description/
    /*
    Input: intervals = [[1,3],[3,7],[8,9]]  Output: 5
    Explanation: let nums = [2, 3, 4, 8, 9].
    It can be shown that there cannot be any containing array of size 4.

    Input: intervals = [[1,3],[1,4],[2,5],[3,5]]    Output: 3
    Explanation: let nums = [2, 3, 4].


     */


    // Sort intervals by end in ascending order, and by start in descending order for equal ends.
    //
    // Greedily pick the largest possible values from each interval to minimize overlap.

    public int intersectionSizeTwo(int[][] intervals) {
        // Sort by end ascending, start descending
        Arrays.sort(intervals, (a, b) ->
                a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0])
        );

        List<Integer> res = new ArrayList<>();
        int x = -1, y = -1; // two largest elements in current intersection

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];

            if (start > y) {
                // No overlap with x or y
                res.add(end - 1);
                res.add(end);
                x = end - 1;
                y = end;
            } else if (start > x) {
                // Only y is in range
                res.add(end);
                x = y;
                y = end;
            }
            // else both x and y are in the interval, do nothing
        }

        return res.size();
    }


    public static void main(String[] args) {
        SetIntersectionSize sol = new SetIntersectionSize();
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        System.out.println(sol.intersectionSizeTwo(intervals)); // Output: 3
    }


}
