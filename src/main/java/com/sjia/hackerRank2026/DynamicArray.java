package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-dynamic-array

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Create 2D structure: a List containing 'n' dynamic ArrayLists
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        List<Integer> result = new ArrayList<>();
        int lastAnswer = 0;

        for (List<Integer> query : queries) {
            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            // Compute target sub-list index
            int idx = (x ^ lastAnswer) % n;

            if (type == 1) {
                // Query 1: Append y to arr[idx]
                arr.get(idx).add(y);
            } else if (type == 2) {
                // Query 2: Retrieve element from arr[idx] using modulo of size
                List<Integer> seq = arr.get(idx);
                int elementIdx = y % seq.size();
                lastAnswer = seq.get(elementIdx);
                result.add(lastAnswer);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        List<List<Integer>> queries = List.of(
                List.of(1, 0, 5),
                List.of(1, 1, 7),
                List.of(1, 0, 3),
                List.of(2, 1, 0),
                List.of(2, 1, 1)
        );

        List<Integer> result = dynamicArray(n, queries);
        System.out.println("Output: " + result); // Output: [7, 3]
    }

}
