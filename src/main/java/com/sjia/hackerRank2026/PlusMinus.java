package com.sjia.hackerRank2026;

import java.util.List;

public class PlusMinus {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-plus-minus/

    // printf %6f%n
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positiveCount=0, zeroCount=0, negativeCount=0;
        int size = arr.size();
        for (int n : arr) {
            if (n >0) positiveCount++;
            else if ( n < 0) negativeCount++;
            else zeroCount++;
        }
        System.out.printf("%6f%n", positiveCount/(double)size);
        System.out.printf("%6f%n", negativeCount/(double)size);
        System.out.printf("%6f%n", zeroCount/(double)size);

    }
}
