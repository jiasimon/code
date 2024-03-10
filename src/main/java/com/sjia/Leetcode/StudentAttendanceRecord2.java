package com.sjia.Leetcode;

import java.util.Arrays;

public class StudentAttendanceRecord2 {
    // #552. Student Attendance Record II   https://leetcode.com/problems/student-attendance-record-ii/description/

    /*
    'A': Absent.
    'L': Late.
    'P': Present.
    Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.

    Input: n = 2        Output: 8
    Explanation: There are 8 records with length 2 that are eligible for an award:
    "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
    Only "AA" is not eligible because there are 2 absences

    Input: n = 1        Output: 3

    Input: n = 10101    Output: 183236316

    1 <= n <= 10^5
     */

    public int checkRecord(int n) {
        final int kMod = 1_000_000_007;
        // dp[i][j] := the length so far with i A's and the last letters are j L's
        long[][] dp = new long[2][3];
        dp[0][0] = 1;

        while (n-- > 0) {
            long[][] prev = Arrays.stream(dp)
                    .map((long[] A) -> A.clone())
                    .toArray((int length) -> new long[length][]);

            // Append a P.
            dp[0][0] = (prev[0][0] + prev[0][1] + prev[0][2]) % kMod;

            // Append an L.
            dp[0][1] = prev[0][0];

            // Append an L.
            dp[0][2] = prev[0][1];

            // Append an A or append a P.
            dp[1][0] =
                    (prev[0][0] + prev[0][1] + prev[0][2] + prev[1][0] + prev[1][1] + prev[1][2]) % kMod;

            // Append an L.
            dp[1][1] = prev[1][0];

            // Append an L.
            dp[1][2] = prev[1][1];
        }

        return (int) ((dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2]) % kMod);
    }

    public static void main(String[] args) {
        StudentAttendanceRecord2 studentAttendanceRecord2 = new StudentAttendanceRecord2();

        System.out.println(studentAttendanceRecord2.checkRecord(3)); // Output: 19
        System.out.println(studentAttendanceRecord2.checkRecord(5)); // Output: 94

    }
}
