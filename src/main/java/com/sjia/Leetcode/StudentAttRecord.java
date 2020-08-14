package com.sjia.Leetcode;

public class StudentAttRecord {
    // #551 https://leetcode.com/problems/student-attendance-record-i/
    // doesn't contain more than one 'A' (absent) or more than two continuous 'L'

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Student Attendance Record I.
    //Memory Usage: 39.4 MB, less than 13.08% of Java online submissions for Student Attendance Record I.
    public boolean checkRecord(String s) {
        return  !( s.indexOf("A")!=s.lastIndexOf("A") ) && s.indexOf("LLL")<0;

    }


    // regex
    // Runtime: 11 ms, faster than 5.17% of Java online submissions for Student Attendance Record I.
    //Memory Usage: 39.3 MB, less than 15.17% of Java online submissions for Student Attendance Record I.
/*
    public boolean checkRecord(String s) {
        return  !s.matches(".*(A.*A|LLL).*");

    }*/


}
