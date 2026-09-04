package com.sjia.hackerRank2026;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IcecreamParlor {
    // https://www.hackerrank.com/challenges/icecream-parlor/problem
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        int n = arr.size();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i=0; i<n; i++) {
            if (seen.containsKey(m-arr.get(i))) {
                int tmp = seen.get(m-arr.get(i));
                if ( i < tmp) {
                    return Arrays.asList(i+1,tmp+1);
                } else {
                    return Arrays.asList(tmp+1, i+1);
                }
            } else {
                seen.put(arr.get(i), i);
            }
        }
        return Collections.emptyList();
    }
    
}
