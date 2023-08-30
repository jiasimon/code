package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpsReachHome {
    // #1654. Minimum Jumps to Reach Home   https://leetcode.com/problems/minimum-jumps-to-reach-home/description/

    /*
    A certain bug's home is on the x-axis at position x. Help them get there from position 0.

    The bug jumps according to the following rules:

    It can jump exactly a positions forward (to the right).
    It can jump exactly b positions backward (to the left).
    It cannot jump backward twice in a row.
    It cannot jump to any forbidden positions.
    The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.

    Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.

    Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
    Output: 3
    Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.

    Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
    Output: 2
    Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
     */



    // revisit
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int f : forbidden) {
            forbiddenSet.add(f);
        }

        int maxPosition = 6000; // The maximum possible position
        boolean[][] visited = new boolean[maxPosition * 2 + 1][2]; // visited[position][direction]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // position, jumps, direction

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int jumps = current[1];
            int direction = current[2];

            if (position == x) {
                return jumps;
            }

            int nextForward = position + a;
            int nextBackward = position - b;

            if (nextForward <= maxPosition * 2 && !visited[nextForward][0] && !forbiddenSet.contains(nextForward)) {
                visited[nextForward][0] = true;
                queue.offer(new int[]{nextForward, jumps + 1, 0});
            }

            if (direction == 0 && nextBackward >= 0 && !visited[nextBackward][1] && !forbiddenSet.contains(nextBackward)) {
                visited[nextBackward][1] = true;
                queue.offer(new int[]{nextBackward, jumps + 1, 1});
            }
        }

        return -1; // Cannot reach destination

    }



}
