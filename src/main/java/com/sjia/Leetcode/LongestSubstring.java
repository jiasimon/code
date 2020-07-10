package com.sjia.Leetcode;

import java.util.Arrays;

public class LongestSubstring {

    static int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }

    public static void main(String[] args) {
        String testData = "pwwkewo";
        int result = lengthOfLongestSubstring(testData);
        System.out.println("The length of substring without repeating characters is: " + result);

    }
}
