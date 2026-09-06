package com.sjia.hackerRank2026;

public class Pangrams {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-pangrams

    public static String pangrams(String s) {
        // Write your code here
        String tmp = s.toLowerCase();
        int[] freq = new int[26];
        for (char c : tmp.toCharArray()) {
//            if (c != ' ') {
              if ( c >= 'a' && c <= 'z') {
                freq[c-'a']++;
            }
        }
        for (int count: freq){
            if (count ==0) return "not pangram";
        }
        return "pangram";

    }

}
