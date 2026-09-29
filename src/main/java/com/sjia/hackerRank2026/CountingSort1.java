package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {
    // https://www.hackerrank.com/challenges/countingsort1/problem?isFullScreen=true

    public static List<Integer> countingSort(List<Integer> arr) {
        int[] freq = new int[101];
        for ( int num : arr) {
            freq[num]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<100; i++) {
            res.add(freq[i]);
        }
        return res;
    }
    

}
