package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.List;

public class BreakingRecords {
    // https://www.hackerrank.com/challenges/breaking-best-and-worst-records

    public static List<Integer> breakingRecords(List<Integer> scores) {

        List<Integer> res = new ArrayList<>();
        int min= scores.get(0), max = scores.get(0);
        int countMin =0, countMax=0;
        for (int s: scores) {
            if (s > max) {
                max = s;
                countMax++;
            } else if ( s < min) {
                min = s;
                countMin++;
            }
        }
        res.add(countMax);
        res.add(countMin);
        return res;
    }

}
