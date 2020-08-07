package com.sjia.Leetcode;

import java.util.Arrays;

public class SegmentsInString {

    // #434 https://leetcode.com/problems/number-of-segments-in-a-string/

    // Runtime: 1 ms, faster than 36.39% of Java online submissions for Number of Segments in a String.
    //Memory Usage: 37.4 MB, less than 12.07% of Java online submissions for Number of Segments in a String.
    public int countSegments(String s) {
        if(s.trim().length() == 0) return 0;
        String[] tmp = s.trim().split("\\s+");
        //System.out.println(Arrays.toString(tmp));
        return tmp.length;

    }

    public static void main(String[] args) {

        //String testData = "abacd"; dcaba
        String testData  = " ab ba cd";
        SegmentsInString solution = new SegmentsInString();
        int result = solution.countSegments(testData);

        System.out.printf(" input %s , SegmentsInString is %s",testData, result);
    }
}
