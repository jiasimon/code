package com.sjia.hackerRank2026;

import java.util.List;

public class CountInversions {
    // https://www.hackerrank.com/challenges/ctci-merge-sort/problem

    // O(N^2) naive
    public static long countInversions2(List<Integer> arr) {
        // Write your code here
        if (arr.size() <= 1) return 0;

        long res=0;
        for (int i=0; i<arr.size(); i++){
            for (int j=i+1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    res++;
                }
            }
        }
        return res;
    }


}
