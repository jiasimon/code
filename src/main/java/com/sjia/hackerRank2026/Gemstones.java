package com.sjia.hackerRank2026;

import java.util.List;

public class Gemstones {
    // https://www.hackerrank.com/challenges/gem-stones/problem?isFullScreen=true

    public static int gemstones(List<String> arr) {
        int[] count = new int[26];
        for (String rock : arr) {
    // Track letters seen in this rock
            boolean[] seen = new boolean[26];
            for (char c : rock.toCharArray()) {
                int index = c - 'a';
                if (!seen[index]) {
                    seen[index] = true;
                    count[index]++;
                }
            }
        }
    // A gemstone appears in every rock
        int gemstones = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == arr.size()) {
                gemstones++;
            }
        }
        return gemstones;
    }

}
