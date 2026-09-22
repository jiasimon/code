package com.sjia.hackerRank2026;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeautifulTriplets {
    // https://www.hackerrank.com/challenges/beautiful-triplets/problem?isFullScreen=true

    public static int beautifulTriplets(int d, List<Integer> arr) {
        int res=0;
        Set<Integer> myset = new HashSet<>(arr);
        for (int num : arr) {
            if (myset.contains(num+d) && myset.contains(num+2*d)) {
                res++;
            }
        }
        return res;
    }

}
