package com.sjia.hackerRank2026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagrams {
    // https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem


    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i=0; i < n; i++) {
            for (int j=i+1; j<=n; j++) {
                String sub = s.substring(i,j);
                char[] tmp = sub.toCharArray();
                Arrays.sort(tmp);
                String sorted = new String(tmp);
                map.put(sorted, map.getOrDefault(sorted, 0) + 1);
            }
        }

        int res=0;
        for (int t: map.values()) {
            res += t*(t-1)/2;
        }
        return res;
    }

}
