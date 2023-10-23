package com.sjia.Leetcode;

import java.util.Arrays;

public class NumberOfSeniorCitizens {
    // #2678. Number of Senior Citizens     https://leetcode.com/problems/number-of-senior-citizens/
    // #stream

    /*
    You are given a 0-indexed array of strings details. Each element of details provides information about a given passenger compressed into a string of length 15. The system is such that:

    The first ten characters consist of the phone number of passengers.
    The next character denotes the gender of the person.
    The following two characters are used to indicate the age of the person.
    The last two characters determine the seat allotted to that person.
    Return the number of passengers who are strictly more than 60 years old.

    Input: details = ["7868190130M7522","5303914400F9211","9273338290F4010"]    Output: 2
    Input: details = ["1313579440F2036","2921522980M5644"]                      Output: 0

    1 <= details.length <= 100
    details[i].length == 15

    details[i] consists of digits from '0' to '9'.
    details[i][10] is either 'M' or 'F' or 'O'.
     */

    // Integer.parseInt, substring(11,13)
    // 1 ms, 77%; 41.2 MB, 63.59%
    public int countSeniors(String[] details) {
        int res =0;
        for ( String detail: details) {
            if ( Integer.parseInt(detail.substring(11,13)) > 60) {
                res++;
            }
        }

        return res;

    }


    // stream filter count
    // 4 ms, 11.94%; 41.5 MB, 45.19%
    public int countSeniors_stream(String[] details) {
        return (int) Arrays.stream(details)
                .filter(detail -> Integer.parseInt(detail.substring(11, 13)) > 60)
                .count();

    }



    public static void main(String[] args) {
        NumberOfSeniorCitizens solution = new NumberOfSeniorCitizens();
        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};

        int seniorCitizens = solution.countSeniors(details);
        System.out.println("Number of Senior Citizens: " + seniorCitizens); // Output: 2
    }
}
