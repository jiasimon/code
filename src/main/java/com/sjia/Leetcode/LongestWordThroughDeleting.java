package com.sjia.Leetcode;

import java.util.List;

public class LongestWordThroughDeleting {
    // #524. Longest Word in Dictionary through Deleting    https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/

    /*
    Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

    Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]     Output: "apple"
    Input: s = "abpcplea", dictionary = ["a","b","c"]   Output: "a"

    1 <= s.length <= 1000
    1 <= dictionary.length <= 1000
    1 <= dictionary[i].length <= 1000
    s and dictionary[i] consist of lowercase English letters.
     */


    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";

        for (String word : d) {
            int i = 0, j = 0;

            // Check if word is a subsequence of s
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }

            // If the whole word is a subsequence and it is longer than the current longestWord
            if (j == word.length() && word.length() >= longestWord.length()) {
                // If lengths are equal, choose lexicographically smaller word
                if (word.length() > longestWord.length() || word.compareTo(longestWord) < 0) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        LongestWordThroughDeleting solution = new LongestWordThroughDeleting();

        String s = "abpcleamf";
        List<String> dictionary = List.of("ale", "apple", "monkey", "plea");

        String longestWord = solution.findLongestWord(s, dictionary);
        System.out.println("Longest word in the dictionary through deleting: " + longestWord);
    }


}
