package com.sjia.Leetcode;

public class TeemoAttacking {
    // #495. Teemo Attacking    https://leetcode.com/problems/teemo-attacking/
    /*
    an attack at second t will mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1]. If Teemo attacks again before the poison effect ends, the timer for it is reset, and the poison effect will end duration seconds after the new attack.

    You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at second timeSeries[i], and an integer duration.

    Return the total number of seconds that Ashe is poisoned.

    Input: timeSeries = [1,4], duration = 2     Output: 4
    Explanation: Teemo's attacks on Ashe go as follows:
    - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
    - At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
    Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.

    Input: timeSeries = [1,2], duration = 2     Output: 3

    1 <= timeSeries.length <= 10^4
    0 <= timeSeries[i], duration <= 10^7
    timeSeries is sorted in non-decreasing order.
     */



    // merge interval, i < n-1
    // 2 ms, 98.2%; 44.8 MB, 42.49%
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length ==0 || duration == 0) {
            return 0;
        }

        int res = 0;
        int n = timeSeries.length;

        for ( int i=0; i < n-1; i++) {
            res += Math.min( timeSeries[i + 1] - timeSeries[i],  duration);

        }

        return res + duration; // Add the last duration

    }

    public static void main(String[] args) {
        TeemoAttacking solution = new TeemoAttacking();
        int[] timeSeries = {1, 4};
        int duration = 4;

        int totalDuration = solution.findPoisonedDuration(timeSeries, duration);
        System.out.println("Total Duration of Poisoning: " + totalDuration);
    }
}
