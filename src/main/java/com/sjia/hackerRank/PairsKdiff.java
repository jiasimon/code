package com.sjia.hackerRank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsKdiff {
    // https://www.hackerrank.com/challenges/pairs/problem?isFullScreen=true&h_l=interview&playlist_slugs[]=interview-preparation-kit&playlist_slugs[]=search

    /*
    similar to Leetcode #532
     */

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Set<Integer> visited = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : arr) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();


    }
}
