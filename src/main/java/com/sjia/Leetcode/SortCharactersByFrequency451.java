package com.sjia.Leetcode;

import java.util.*;

public class SortCharactersByFrequency451 {
    // #451. Sort Characters By Frequency   https://leetcode.com/problems/sort-characters-by-frequency/

    /*
    Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

    Return the sorted string. If there are multiple answers, return any of them.

    Input: s = "tree"       Output: "eert"
    Input: s = "cccaaa"     Output: "aaaccc"
    Input: s = "Aabb"       Output: "bbAa"
     */

    public String frequencySort(String s) {
        // Create a map to store character frequency counts
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count the frequency of each character in the input string
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue (min-heap) to sort characters by their frequency
        PriorityQueue<Character> minHeap = new PriorityQueue<>(
                (a, b) -> charCountMap.get(b) - charCountMap.get(a)
        );

        // Add all unique characters to the min-heap
        for (char c : charCountMap.keySet()) {
            minHeap.offer(c);
        }

        // Build the sorted string
        StringBuilder sortedString = new StringBuilder();

        // Poll characters from the min-heap and append them to the result string
        while (!minHeap.isEmpty()) {
            char c = minHeap.poll();
            int count = charCountMap.get(c);
            for (int i = 0; i < count; i++) {
                sortedString.append(c);
            }
        }

//        return sortedString.reverse().toString(); // Reverse the result string
        return sortedString.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency451 sorter = new SortCharactersByFrequency451();
        String input = "tree";
        String sorted = sorter.frequencySort(input);
        System.out.println(sorted); // Output: "eetr" or "eert" or "reet" or "rtee"
    }
}
