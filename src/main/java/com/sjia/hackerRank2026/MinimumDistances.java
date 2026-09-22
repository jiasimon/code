package com.sjia.hackerRank2026;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistances {
    // https://www.hackerrank.com/challenges/minimum-distances/problem?isFullScreen=true

    public static int minimumDistances(List<Integer> a) {

        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<a.size(); i++) {
            int current = a.get(i);
            if(map.containsKey(current)) {
                int distance = i- map.get(current);
                res= Math.min(res, distance);
            }
            map.put(current, i);
        }
        if (res== Integer.MAX_VALUE) return -1;
        else return res;

    }

}
