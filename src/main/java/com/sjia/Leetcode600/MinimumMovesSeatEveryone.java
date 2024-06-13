package com.sjia.Leetcode600;

import java.util.Arrays;

public class MinimumMovesSeatEveryone {
    // #2037. Minimum Number of Moves to Seat Everyone  https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/?envType=daily-question&envId=2024-06-13
    /*
    Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position x to x + 1 or x - 1)
    Return the minimum number of moves required to move each student to a seat such that no two students are in the same seat.

    Note that there may be multiple seats or students in the same position at the beginning.

    Input: seats = [3,1,5], students = [2,7,4]      Output: 4

    Input: seats = [4,1,5,9], students = [1,3,2,6]  Output: 7

    Input: seats = [2,2,6,6], students = [1,3,2,6]  Output: 4
     */

    // sort seats and students
    public int minMovesToSeat(int[] seats, int[] students) {
        int res = 0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; ++i)
            res += Math.abs(seats[i] - students[i]);

        return res;
    }



}
