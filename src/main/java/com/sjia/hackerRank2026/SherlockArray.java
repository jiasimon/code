package com.sjia.hackerRank2026;

import java.util.List;

public class SherlockArray {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-sherlock-and-array/problem

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        long total=0;
        for (int n: arr) {
            total += n;
        }
        long leftSum=0;
        for (int i=0; i < arr.size(); i++){
            if (leftSum == (total - leftSum -arr.get(i))) return "YES";
            leftSum = leftSum +arr.get(i);
        }
        return "NO";
    }
}
