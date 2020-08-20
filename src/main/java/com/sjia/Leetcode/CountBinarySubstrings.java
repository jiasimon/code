package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    // #696 https://leetcode.com/problems/count-binary-substrings/

    // use list to store continuous 0 or 1
    // Runtime: 11 ms, faster than 51.62% of Java online submissions for Count Binary Substrings.
    //Memory Usage: 40.2 MB, less than 52.37% of Java online submissions for Count Binary Substrings.
    public int countBinarySubstrings(String s) {
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
    }



    public static void main(String[] args) {
        String testData  = "00110";
        CountBinarySubstrings solution = new CountBinarySubstrings();
        int result = solution.countBinarySubstrings(testData);

        System.out.printf(" input %s isPalindrome: %s ", testData, result);
    }


}
