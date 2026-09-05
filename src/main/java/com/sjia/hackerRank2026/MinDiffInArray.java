package com.sjia.hackerRank2026;

import java.util.Collections;
import java.util.List;

public class MinDiffInArray {
    // https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        long res= Long.MAX_VALUE;
        int n = arr.size();

        for(int i=0; i<n-1; i++){
            res = Math.min(res, arr.get(i+1) - arr.get(i));
        }
        return (int)res;

    }

    public static int minimumAbsoluteDifferenceSort(List<Integer> arr) {
        Collections.sort(arr);
        int res = Integer.MAX_VALUE;
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, arr.get(i + 1) - arr.get(i));
        }
        return res;
    }

}
