package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberBoomerangs {

    // #447 https://leetcode.com/problems/number-of-boomerangs/

    // Runtime: 95 ms, faster than 77.30% of Java online submissions for Number of Boomerangs.
    //Memory Usage: 39.7 MB, less than 26.32% of Java online submissions for Number of Boomerangs.
    public int numberOfBoomerangs(int[][] points) {
        int result =0;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i=0; i < points.length; i++) {
            for (int j=0; j< points.length; j++) {
                if (i==j) continue;
                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d,0)+1);

            }
            for (int v: map.values()) {
                result += v*(v-1);
            }
            map.clear();

        }
        return result;

    }

    private int getDistance(int[] x, int[] y) {
        int a = x[0] - y[0];
        int b = x[1] - y[1];
        return a*a + b*b;
    }


}
