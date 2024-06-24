package com.sjia.Leetcode600;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
    // #677. Map Sum Pairs  https://leetcode.com/problems/map-sum-pairs/description/
    /*
    ["MapSum", "insert", "sum", "insert", "sum"] [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
    Output
    [null, null, 3, null, 5]

     */

    private Map<String, Integer> map;
    private Map<String, Integer> prefixMap;

    /** Initialize your data structure here. */
    public MapSumPairs() {
        map = new HashMap<>();
        prefixMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + delta);
        }
    }

    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }

    public static void main(String[] args) {
        MapSumPairs mapSum = new MapSumPairs();

        // Test case 1
        mapSum.insert("apple", 3);
        System.out.println("Test case 1: " + mapSum.sum("ap")); // Expected output: 3

        // Test case 2
        mapSum.insert("app", 2);
        System.out.println("Test case 2: " + mapSum.sum("ap")); // Expected output: 5

        // Test case 3
        mapSum.insert("apple", 2);
        System.out.println("Test case 3: " + mapSum.sum("ap")); // Expected output: 4

        // Test case 4
        mapSum.insert("banana", 5);
        System.out.println("Test case 4: " + mapSum.sum("ban")); // Expected output: 5

        // Test case 5
        mapSum.insert("app", 5);
        System.out.println("Test case 5: " + mapSum.sum("ap")); // Expected output: 7
    }

}
