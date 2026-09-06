package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.List;

public class CountSort1 {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-countingsort1
    
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[100];
        for (int n : arr) {
            freq[n]++;
        }

        for (int n: freq){
            res.add(n);
        }
        return res;
    }

}
