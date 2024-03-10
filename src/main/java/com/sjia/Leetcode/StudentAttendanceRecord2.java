package com.sjia.Leetcode;

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
        int MOD = 1000000007;
        long[] P = new long[n + 1]; // P[i] represents the number of all possible attendance records ending with 'P'
        long[] L = new long[n + 1]; // L[i] represents the number of all possible attendance records ending with 'L'
        long[] A = new long[n + 1]; // A[i] represents the number of all possible attendance records ending with 'A'

        P[0] = 1;
        L[0] = 1;
        L[1] = 1;
        A[0] = 1;
        A[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = (P[i - 1] + L[i - 1] + A[i - 1]) % MOD;
            A[i] = (P[i - 1] + L[i - 1] + P[i - 2] + L[i - 2]) % MOD;
            L[i] = (P[i - 1] + A[i - 1] + P[i - 2] + A[i - 2]) % MOD;
        }

        long res = (P[n] + L[n] + A[n]) % MOD;
        return (int) res;
    }

    public static void main(String[] args) {
        StudentAttendanceRecord2 studentAttendanceRecord2 = new StudentAttendanceRecord2();

        System.out.println(studentAttendanceRecord2.checkRecord(3)); // Output: 20
        System.out.println(studentAttendanceRecord2.checkRecord(5)); // Output: 164

    }
}
