package com.sjia.Leetcode;

public class StudentAttendanceRecord {
    // #551. Student Attendance Record I    https://leetcode.com/problems/student-attendance-record-i/description/

    /*
    You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

    'A': Absent.
    'L': Late.
    'P': Present.

    The student is eligible for an attendance award if they meet both of the following criteria:

    The student was absent ('A') for strictly fewer than 2 days total.
    The student was never late ('L') for 3 or more consecutive days.
    Return true if the student is eligible for an attendance award, or false otherwise.

    Input: s = "PPALLP"     Output: true

    Input: s = "PPALLL"     Output: false
     */

    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absentCount++;
                lateCount = 0; // Reset late count if absent
                if (absentCount > 1) {
                    return false; // More than one absence
                }
            } else if (c == 'L') {
                lateCount++;
                if (lateCount > 2) {
                    return false; // More than two consecutive late
                }
            } else {
                lateCount = 0; // Reset late count if present
            }
        }

        return true;
    }


    public static void main(String[] args) {
        StudentAttendanceRecord studentAttendanceRecord = new StudentAttendanceRecord();

        System.out.println(studentAttendanceRecord.checkRecord("PPALLP")); // Output: true
        System.out.println(studentAttendanceRecord.checkRecord("PPALLL")); // Output: false

    }


}
