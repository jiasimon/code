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

    public static int sherlockAndAnagramsByLength(String s) {
        int n = s.length();
        Map<String, Integer> freq = new HashMap<>();

        // Generate all substrings, normalize each by sorting its characters,
        // and count occurrences of each normalized form.
        for (int len = 1; len < n; len++) {
            for (int start = 0; start + len <= n; start++) {
                String sub = s.substring(start, start + len);
                char[] chars = sub.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                freq.put(key, freq.getOrDefault(key, 0) + 1);
            }
        }

        // For each group of k substrings that are anagrams of each other,
        // the number of pairs is k choose 2 = k * (k - 1) / 2.
        long totalPairs = 0;
        for (int count : freq.values()) {
            totalPairs += (long) count * (count - 1) / 2;
        }

        return (int) totalPairs;
    }

}
