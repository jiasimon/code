package com.sjia.hackerRank2026;

import java.util.List;

public class DiagonalDifference {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-diagonal-difference/

    // arr.get(i).get(n-1-i)
    public static int diagonalDifference(List<List<Integer>> arr) {
        int res=0, sum1=0, sum2=0;
        int n = arr.size();
        for(int i=0; i < n; i++) {
            sum1 += arr.get(i).get(i);
            sum2 += arr.get(i).get(n-1-i);
        }
        res = Math.abs(sum1-sum2);
        return res;
    }
    
}
