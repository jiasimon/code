package com.sjia.hackerRank2026;

import java.util.Comparator;
import java.util.List;

public class PermutingTwoArrays {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-two-arrays

    // A.sort(Comparator.naturalOrder())
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());
        for (int i=0; i< A.size(); i++ ) {
            if (A.get(i) + B.get(i) < k ) return "NO";
        }
        return "YES";
    }
}
