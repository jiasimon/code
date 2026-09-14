package com.sjia.hackerRank2026;

import java.util.List;

public class DivisibleSumPairs {
    // https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?isFullScreen=true

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int res=0;
        for (int i=0; i < n; i++) {
            for (int j=i+1; j < n; j++) {
                if ( (ar.get(i) + ar.get(j))/ k * k ==(ar.get(i) + ar.get(j))) {
                    res++;
                }
            }
        }
        return res;
    }

}
