package com.sjia.Leetcode;

import java.util.*;

public class ConcatenatedWords472 {
    // #472. Concatenated Words     https://leetcode.com/problems/concatenated-words/description/

    /*
    Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

    A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.

    Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
    Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

    Input: words = ["cat","dog","catdog"]
    Output: ["catdog"]

    1 <= words.length <= 10000
    1 <= words[i].length <= 30
    words[i] consists of only lowercase English letters.
    All the strings of words are unique.
    1 <= sum(words[i].length) <= 100000

    Refer to https://leetcode.com/problems/word-break/
     */


    // DP,
    // 66 ms, 44.20%; 48.4 MB, 58.86%
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new LinkedList<>();

        for (String word : words) {
            wordSet.remove(word);
            if (canFormWord(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }

        return result;
    }

    private boolean canFormWord(String word, Set<String> wordSet) {
        int n = word.length();
        if (n == 0) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }



    // map memo
    // 74 ms, 27.74%; 51.9 MB, 28.82%
    public List<String> findAllConcatenatedWordsInADict_memo(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> memo = new HashMap<>();

        for (final String word : words)
            if (wordBreak(word, wordSet, memo))
                ans.add(word);

        return ans;
    }

    private boolean wordBreak(final String word, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(word))
            return memo.get(word);

        for (int i = 1; i < word.length(); ++i) {
            final String prefix = word.substring(0, i);
            final String suffix = word.substring(i);
            if (wordSet.contains(prefix) &&
                    (wordSet.contains(suffix) || wordBreak(suffix, wordSet, memo))) {
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }



    public static void main(String[] args) {
        ConcatenatedWords472 solution = new ConcatenatedWords472();
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatsdogcat"};

        List<String> concatenatedWords = solution.findAllConcatenatedWordsInADict_memo(words);
        System.out.println("Concatenated Words: " + concatenatedWords);
        // Output: ["catsdogcats","dogcatsdog","ratcatsdogcat"]
    }

}
