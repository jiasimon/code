package com.sjia.Leetcode;

public class SelfCrossing {
    // #335. Self Crossing  https://leetcode.com/problems/self-crossing/
    /*
    You start at the point (0, 0) on an X-Y plane, and you move distance[0] meters to the north, then distance[1] meters to the west, distance[2] meters to the south, distance[3] meters to the east, and so on. In other words, after each move, your direction changes counter-clockwise.

    Return true if your path crosses itself or false if it does not.
    Input: distance = [2,1,1,2] Output: true


     */
    /*               i-2
        case 1 : i-1┌─┐
                    └─┼─>i
                     i-3

                        i-2
        case 2 : i-1 ┌────┐
                     └─══>┘i-3
                     i  i-4      (i overlapped i-4)
    case 3 :    i-4
                   ┌──┐
                   │i<┼─┐
                i-3│ i-5│i-1
                   └────┘
                    i-2
    */

    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;

        if (n <= 3) {
            return false;
        }

        for (int i = 3; i < n; i++) {
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true; // Case 1
            }

            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true; // Case 2
            }

            if (i >= 5 && distance[i - 2] >= distance[i - 4] && distance[i] + distance[i - 4] >= distance[i - 2]
                    && distance[i - 1] <= distance[i - 3] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true; // Case 3
            }

            if (i >= 6 && distance[i - 2] >= distance[i - 4] && distance[i] + distance[i - 4] >= distance[i - 2]
                    && distance[i - 1] <= distance[i - 3] && distance[i - 1] + distance[i - 5] >= distance[i - 3]
                    && distance[i - 5] <= distance[i - 3] && distance[i - 1] + distance[i - 5] >= distance[i - 3] - distance[i - 1]
            ) {
                return true; // Case 4
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SelfCrossing solution = new SelfCrossing();
        int[] distance = {2, 1, 1, 2};
        System.out.println(solution.isSelfCrossing(distance)); // Output: true
    }



}
