package com.sjia.hackerRank2026;

import java.util.List;

public class MigratoryBirds {
    // https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=true

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int[] tmp = new int[6];
        for (int n : arr ) {
            tmp[n]++;
        }
        int res=0, maxFreq=0;
        for (int i=1; i <6; i++ ) {
            if (tmp[i] > maxFreq) {
                maxFreq = tmp[i];
                res=i;
            }
        }
        return res;
    }

}
