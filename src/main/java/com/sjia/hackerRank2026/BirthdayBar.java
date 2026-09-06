package com.sjia.hackerRank2026;

import java.util.List;

public class BirthdayBar {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-the-birthday-bar/
    // Subarray Division 1

    // sliding window, window -s.get(i)+s.get(i+m)
    public static int birthday(List<Integer> s, int d, int m) {
        int size = s.size();
        if (m > size) return 0;
        int res=0;
        int window = 0;
        for (int i=0; i < m; i++) {
            window += s.get(i);
        }
        if (window == d) {
            res++;
        }

        for (int i=0; i<size-m; i++) {
            window = window -s.get(i)+s.get(i+m);
            if (window == d) {
                res++;
            }
        }
        return res;
    }

}
