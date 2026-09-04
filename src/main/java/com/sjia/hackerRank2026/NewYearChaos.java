package com.sjia.hackerRank2026;

import java.util.List;

public class NewYearChaos {
    // https://www.hackerrank.com/challenges/new-year-chaos/problem
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        for ( int i=0; i < q.size(); i++) {
            if (q.get(i) - (i+1) >2 ) {
                System.out.println("Too chaotic");
                return;
            }
            int start = Math.max(0, q.get(i) - 2);
            for (int j =start; j < i; j++) {
                if (q.get(j) > q.get(i)) bribes++;
            }
        }
        System.out.println(bribes);
    }

}
