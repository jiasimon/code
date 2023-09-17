package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberBoomerangs {

    // #447. Number of Boomerangs https://leetcode.com/problems/number-of-boomerangs/

    /*
    You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

    Return the number of boomerangs.
    Input: points = [[0,0],[1,0],[2,0]]     Output: 2
    Input: points = [[1,1],[2,2],[3,3]]     Output: 2
    Input: points = [[1,1]]                 Output: 0

    1 <= n <= 500
    -10000 <= xi, yi <= 10000
     */



    // n*(n-1) , distanceFreq map, map.clear
    // 98 ms, 66.67%, 43.5 MB,76.6%
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


    public static void main(String[] args) {
        NumberBoomerangs solution = new NumberBoomerangs();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};

        int boomerangs = solution.numberOfBoomerangs(points);
        System.out.println("Number of Boomerangs: " + boomerangs); // Output: 2
    }


}
