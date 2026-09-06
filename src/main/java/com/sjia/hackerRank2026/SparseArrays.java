package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseArrays {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-sparse-arrays

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String input: strings) {
            map.put(input, map.getOrDefault(input, 0)+1);
        }
        for (String query: queries ) {
//            if (map.containsKey(query)) {
//                res.add(map.get(query));
//            }
//            else {
//                res.add(0);
//            }
            res.add(map.getOrDefault(query, 0)) ;
        }
        return res;
    }
}
