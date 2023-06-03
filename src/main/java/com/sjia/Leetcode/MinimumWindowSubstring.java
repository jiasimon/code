package com.sjia.Leetcode;

import java.util.*;

public class MinimumWindowSubstring {
    // #76. Minimum Window Substring  https://leetcode.com/problems/minimum-window-substring/ #fb

    // Input: s = "ADOBECODEBANC", t = "ABC"    Output: "BANC"
    // Input: s = "a", t = "a"  Output: "a"

    // Given two strings s and t, return the minimum window in s which will contain all the characters in t.
    // If there is no such window in s that covers all characters in t, return the empty string ""
    // it is guaranteed that there will always be only one unique minimum window in s.

    // 1 <= s.length, t.length <= 105
    // s and t consist of English letters.
    // note: t can have duplicate characters

    // Runtime: 4 ms, faster than 85.34% of Java online submissions for Minimum Window Substring.
    //Memory Usage: 38.8 MB, less than 97.89% of Java online submissions for Minimum Window Substring.
    
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        int[] map = new int[128];
        for (char c: t.toCharArray()) {
            map[c]++;
        }

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            char tmp = s.charAt(end);
            if(map[tmp] >0 ) counter--;
            map[tmp]--;
            end++;

            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if(map[c2] > 0) counter++;
                start++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

    }







/*
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 11);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0){
                    count ++;
                }
                while(count == t.length()){
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left)) > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        if(minLen>s.length())
        {
            return "";
        }

        return s.substring(minLeft,minLeft+minLen);
    }*/




    public static String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (targetMap.containsKey(rightChar)) {
                if (targetMap.get(rightChar) > 0) {
                    count--;
                }
                targetMap.put(rightChar, targetMap.get(rightChar) - 1);
            }
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    targetMap.put(leftChar, targetMap.get(leftChar) + 1);
                    if (targetMap.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }



    public static void main(String[] args) {
        String testData  = "ADOBECODEBANC";
        String testData2  = "ABC";
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String result = solution.minWindow2(testData, testData2);

        System.out.printf("testData %s and testData2 %s minWindow is %s \n",
                testData,testData2, result);
    }


}
