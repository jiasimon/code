package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceEquation {
    // https://www.hackerrank.com/challenges/permutation-equation

    public static List<Integer> permutationEquation(List<Integer> p) {
        int n = p.size();
        // Map to store value -> 1-based index
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();

        // Populate the map with 1-based indexing
        for (int i = 0; i < n; i++) {
            valueToIndexMap.put(p.get(i), i + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Find y for each x from 1 to n
        for (int x = 1; x <= n; x++) {
            int positionOfX = valueToIndexMap.get(x);
            int y = valueToIndexMap.get(positionOfX);
            result.add(y);
        }

        return result;
    }
}
