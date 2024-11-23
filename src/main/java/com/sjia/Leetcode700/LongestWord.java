package com.sjia.Leetcode700;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWord {
    // #720. Longest Word in Dictionary     https://leetcode.com/problems/longest-word-in-dictionary/description/
    /*

     */


    public String longestWord(String[] words) {
        // Sort words lexicographically
        Arrays.sort(words);

        // Use a HashSet to store valid words
        HashSet<String> built = new HashSet<>();
        String longest = "";

        for (String word : words) {
            // A word is valid if its prefix (word without the last character) exists in the set
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                built.add(word);

                // Update the longest word if necessary
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestWord solution = new LongestWord();

        // Test Case 1
        String[] words1 = {"w", "wo", "wor", "worl", "world"};
        System.out.println(solution.longestWord(words1)); // Output: "world"

        // Test Case 2
        String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(solution.longestWord(words2)); // Output: "apple"

        // Test Case 3
        String[] words3 = {"abc", "a", "ab", "abcd"};
        System.out.println(solution.longestWord(words3)); // Output: "abcd"
    }


}
