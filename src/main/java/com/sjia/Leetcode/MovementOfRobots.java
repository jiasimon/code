package com.sjia.Leetcode;

import java.util.Arrays;

public class MovementOfRobots {
    // #2731. Movement of Robots    https://leetcode.com/problems/movement-of-robots/description/

    /*
    Some robots are standing on an infinite number line with their initial coordinates given by a 0-indexed integer array nums and will start moving once given the command to move. The robots will move a unit distance each second.

    You are given a string s denoting the direction in which robots will move on command. 'L' means the robot will move towards the left side or negative side of the number line, whereas 'R' means the robot will move towards the right side or positive side of the number line.

    If two robots collide, they will start moving in opposite directions.

    Return the sum of distances between all the pairs of robots d seconds after the command. Since the sum can be very large, return it modulo 10^9 + 7.

    For two robots at the index i and j, pair (i,j) and pair (j,i) are considered the same pair.
    When robots collide, they instantly change their directions without wasting any time.
    Collision happens when two robots share the same place in a moment.

    Input: nums = [-2,0,2], s = "RLL", d = 3        Output: 8
    Explanation:
    After 1 second, the positions are [-1,-1,1]. Now, the robot at index 0 will move left, and the robot at index 1 will move right.
    After 2 seconds, the positions are [-2,0,0]. Now, the robot at index 1 will move left, and the robot at index 2 will move right.
    After 3 seconds, the positions are [-3,-1,1].
    The distance between the robot at index 0 and 1 is abs(-3 - (-1)) = 2.
    The distance between the robot at index 0 and 2 is abs(-3 - 1) = 4.
    The distance between the robot at index 1 and 2 is abs(-1 - 1) = 2.
    The sum of the pairs of all distances = 2 + 4 + 2 = 8.

    2 <= nums.length <= 105
    -2 * 10^9 <= nums[i] <= 2 * 10^9
    0 <= d <= 10^9
    nums.length == s.length
     */


    // Ants on a Plank, sort
    // 12 ms, 12.90%; 57.1 MB, 5.38%
    public int sumDistance(int[] nums, String s, int d) {
        final int kMod = 1_000_000_007;
        final int n = nums.length;
        int ans = 0;
        int prefix = 0;
        int[] pos = new int[n];

        for (int i = 0; i < n; ++i)
            if (s.charAt(i) == 'L')
                pos[i] = nums[i] - d;
            else
                pos[i] = nums[i] + d;

        Arrays.sort(pos);

        for (int i = 0; i < n; ++i) {
            ans = (int) (((ans + 1L * i * pos[i] - prefix) % kMod + kMod) % kMod);
            prefix = (int) (((0L + prefix + pos[i]) % kMod + kMod) % kMod);
        }

        return ans;

    }


    public static void main(String[] args) {
        MovementOfRobots solution = new MovementOfRobots();
        int[] nums = {-2, 0, 2};
        String s = "RLL";
        int d = 3;

        int sum = solution.sumDistance(nums, s, d);
        System.out.println("Sum of Distances: " + sum); // Output: 8
    }
}
