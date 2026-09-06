package com.sjia.hackerRank2026;

public class TimeConversion {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-time-conversion

    public static String timeConversion(String s) {
        // Write your code here
        String hour = s.substring(0,2);
        String rest = s.substring(2,8);
        if (s.contains("AM")) {
            if (hour.equals("12")) {  //  string cannot use "==". eg: hour == "12"
                return "00"+rest;
            }
            else {
                return hour + rest;
            }
        } else {
            if (hour.equals("12")) return hour + rest;
            else {
                int newHour = Integer.parseInt(hour) + 12;
                return newHour + rest;
            }
        }
    }

}
