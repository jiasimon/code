package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    // #696 https://leetcode.com/problems/count-binary-substrings/

    // use list to store continuous 0 and 1
    // Runtime: 11 ms, faster than 51.62% of Java online submissions for Count Binary Substrings.
    //Memory Usage: 40.2 MB, less than 52.37% of Java online submissions for Count Binary Substrings.
/*    public int countBinarySubstrings(String s) {
        List <Integer> tmp = new ArrayList<>();
        int i=0;
        while ( i< s.length()) {
            char c = s.charAt(i);
            int count =0;
            while ( i< s.length() && s.charAt(i)== c) {
                i++;
                count++;
            }
            tmp.add(count);
        }
        int result = 0;
        for (int j = 1; j < tmp.size(); j++) {
            result += Math.min(tmp.get(j), tmp.get(j-1));
        }
        return result;
    }*/



    //
    // Runtime: 8 ms, faster than 91.65% of Java online submissions for Count Binary Substrings.
    //Memory Usage: 39.7 MB, less than 92.25% of Java online submissions for Count Binary Substrings.

    public int countBinarySubstrings(String s) {
        int prevLength = 0, curLength = 1, result = 0;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) curLength++;
            else {
                prevLength = curLength;
                curLength = 1;
            }
            if (prevLength >= curLength) result++;
        }
        return result;
    }


    //

/*
    public int countBinarySubstrings(String s) {
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }*/


    public static void main(String[] args) {
        String testData  = "00111011";
        CountBinarySubstrings solution = new CountBinarySubstrings();
        int result = solution.countBinarySubstrings(testData);

        System.out.printf(" input %s countBinarySubstrings: %s ", testData, result);
    }


}
