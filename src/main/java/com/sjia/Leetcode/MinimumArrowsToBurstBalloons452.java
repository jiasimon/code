package com.sjia.Leetcode;

import java.util.Arrays;

public class MinimumArrowsToBurstBalloons452 {
    // #452. Minimum Number of Arrows to Burst Balloons     https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

    /*
    There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

    Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

    Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

    Input: points = [[10,16],[2,8],[1,6],[7,12]]        Output: 2
    Explanation: The balloons can be burst by 2 arrows:
    - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
    - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

    Input: points = [[1,2],[3,4],[5,6],[7,8]]       Output: 4
    Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.

    Input: points = [[1,2],[2,3],[3,4],[4,5]]       Output: 2
    Explanation: The balloons can be burst by 2 arrows:
    - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
    - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].

    1 <= points.length <= 105
    points[i].length == 2
    -2^31 <= xstart < xend <= 2^31 - 1
     */


    // Integer.compare(a[1], b[1])
    // 50 ms, 96.49%; 75.8 MB, 84.98%
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort the points by their end points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // Initialize with 1 arrow as we will always need at least one

        int end = points[0][1]; // Initialize the end point with the first balloon's end

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                // If the current balloon's start is after the end point, we need another arrow
                arrows++;
                end = points[i][1]; // Update the end point with the current balloon's end
            }
            // Otherwise, the arrow can burst this balloon, so continue with the current end point
        }

        return arrows;
    }




    // (a,b) -> a[1] - b[1], failed on [[-2147483646,-2147483645],[2147483646,2147483647]]
    // return 1 instead of 2
    public int findMinArrowShots_sort(int[][] points) {
        if ( points.length == 1) return 1;

        // Sort the points by their end points
        Arrays.sort(points, (a,b) -> a[1] - b[1]);

        int arrows = 1;

        int end = points[0][1];

        for (int i=1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;

    }


    public static void main(String[] args) {
        MinimumArrowsToBurstBalloons452 solution = new MinimumArrowsToBurstBalloons452();
        int[][] balloons = {{10,16}, {2,8}, {1,6}, {7,12}};
        int minArrows = solution.findMinArrowShots(balloons);
        System.out.println("Minimum arrows needed: " + minArrows); // Output: 2

        int[][] balloons2 = {{-2147483646,-2147483645},  {2147483646,2147483647}};
        minArrows = solution.findMinArrowShots_sort(balloons2);
        System.out.println("Minimum arrows needed: " + minArrows); // Output: 2
    }



}
