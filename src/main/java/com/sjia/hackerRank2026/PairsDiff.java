package com.sjia.hackerRank2026;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsDiff {
    // https://www.hackerrank.com/challenges/pairs/problem

    // HashSet
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        for (int tmp: arr) {
            set.add(tmp);
        }
        // Set<Integer> set = new HashSet<>(arr);

        int res =0;
        for (int n: arr){
            if (set.contains(n+k)) res++;
        }
        return res;
    }

    // two pointers
    public static int pairsDiff(int k, List<Integer> arr) {
        Collections.sort(arr);

        int count = 0;
        int left = 0;
        int right = 1;

        while (right < arr.size()) {
            int diff = arr.get(right) - arr.get(left);

            if (diff == k) {
                count++;
                left++;
                right++;
            } else if (diff < k) {
                right++;
            } else { // diff > k
                left++;
                if (left == right) {
                    right++;
                }
            }
        }

        return count;
    }


}
