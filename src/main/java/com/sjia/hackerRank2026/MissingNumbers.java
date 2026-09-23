package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {
    // https://www.hackerrank.com/challenges/missing-numbers/problem?isFullScreen=true

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        int min = Integer.MAX_VALUE;
        // for ( int n : arr) { failed on index out of boundary
        for ( int n : brr) {
            if(n < min) {
                min = n;
            }
        }

        int[] freq = new int[101];
        for (int num : brr) {
            freq[num - min]++;
        }
        for( int num : arr) {
            freq[num-min]--;
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                missing.add(i + min);
            }
        }
        return missing;
    }

}
