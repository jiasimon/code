package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.List;

public class CircularArrayRotation {
    // https://www.hackerrank.com/challenges/circular-array-rotation

    // (query - k + n) % n
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List <Integer> res = new ArrayList<>();
        int n = a.size();
        k = k % n;

        for (int query : queries) {
            // Formula to find the pre-rotation index
            int originalIndex = (query - k + n) % n;
            res.add(a.get(originalIndex));
        }

        return res;
    }

}
