package com.sjia.hackerRank2026;

import java.util.List;

public class NonDivisibleSubset {
    // https://www.hackerrank.com/challenges/non-divisible-subset/

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] reaminderCount = new int[k];
        for ( int num : s){
            reaminderCount[num%k]++;
        }

        int res=0;
        if(reaminderCount[0] > 0) {
            res++;
        }
        for (int i = 1; i <= k / 2; i++) {
            int tmp = k-i;
            if ( i==tmp ) {
                if (reaminderCount[i] > 0) {
                    res++;
                }
            } else {
                res = res + Math.max(reaminderCount[i], reaminderCount[tmp]);
            }
        }
        return res;
    }

}
