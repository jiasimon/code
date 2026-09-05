package com.sjia.hackerRank2026;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsDiff {
    // https://www.hackerrank.com/challenges/pairs/problem

    // HashSet
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        for (int tmp: arr) {
            set.add(tmp);
        }
        // Set<Integer> set = new HashSet<>(arr);

        int res =0;
        for (int n: arr){
            if (set.contains(n+k)) res++;
        }
        return res;
    }

}
