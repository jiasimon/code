package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    // #539. Minimum Time Difference    https://leetcode.com/problems/minimum-time-difference/description/

    /*
    Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

    Input: timePoints = ["23:59","00:00"]       Output: 1

    Input: timePoints = ["00:00","23:59","00:00"]   Output: 0

    2 <= timePoints.length <= 2 * 10000
    timePoints[i] is in the format "HH:MM".
     */

    public int findMinDifference(List<String> timePoints) {
        int ans = 24 * 60;
        int first = 24 * 60;
        boolean[] bucket = new boolean[24 * 60];

        for (final String timePoint : timePoints) {
            final int num =
                    Integer.valueOf(timePoint.substring(0, 2)) * 60 + Integer.valueOf(timePoint.substring(3));
            first = Math.min(first, num);
            if (bucket[num])
                return 0;
            bucket[num] = true;
        }

        int prev = first;

        for (int i = first + 1; i < bucket.length; ++i)
            if (bucket[i]) {
                ans = Math.min(ans, i - prev);
                prev = i;
            }

        return Math.min(ans, 24 * 60 - prev + first);
    }


    public static void main(String[] args) {
        MinimumTimeDifference solution = new MinimumTimeDifference();

        List<String> timePoints = Arrays.asList("23:59", "00:00", "00:01");
        int minDiff = solution.findMinDifference(timePoints);
        System.out.println("Minimum time difference: " + minDiff + " minutes");
    }



}
