package com.sjia.Leetcode;

import java.util.*;

public class WordLadder2 {
    // #126. Word Ladder II https://leetcode.com/problems/word-ladder-ii/
    /*
    Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
    Explanation: There are 2 shortest transformation sequences:
    "hit" -> "hot" -> "dot" -> "dog" -> "cog"
    "hit" -> "hot" -> "lot" -> "log" -> "cog"

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: []
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
     */

    Map<String, List<String>> graph;
    List<List<String>> results;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return results;
        }

        graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        startSet.add(beginWord);
        endSet.add(endWord);

        buildGraph(wordSet, startSet, endSet, false);

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        bfs(beginWord, endWord, path, visited);

        return results;
    }

    private void buildGraph(Set<String> wordSet, Set<String> startSet, Set<String> endSet, boolean reverse) {
        if (startSet.isEmpty()) {
            return;
        }

        if (startSet.size() > endSet.size()) {
            buildGraph(wordSet, endSet, startSet, !reverse);
            return;
        }

        wordSet.removeAll(startSet);
        boolean found = false;
        Set<String> nextSet = new HashSet<>();

        for (String word : startSet) {
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                char originalChar = wordArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    if (wordSet.contains(newWord)) {
                        nextSet.add(newWord);
                        String key = reverse ? newWord : word;
                        String neighbor = reverse ? word : newWord;
                        graph.putIfAbsent(key, new ArrayList<>());
                        graph.get(key).add(neighbor);
                        if (endSet.contains(newWord)) {
                            found = true;
                        }
                    }
                }
                wordArray[i] = originalChar;
            }
        }

        if (!found) {
            buildGraph(wordSet, nextSet, endSet, reverse);
        }
    }

    private void bfs(String beginWord, String endWord, List<String> path, Set<String> visited) {
        if (beginWord.equals(endWord)) {
            results.add(new ArrayList<>(path));
            return;
        }

        if (!graph.containsKey(beginWord)) {
            return;
        }

        List<String> neighbors = graph.get(beginWord);
        for (String neighbor : neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }
            path.add(neighbor);
            visited.add(neighbor);
            bfs(neighbor, endWord, path, visited);
            path.remove(path.size() - 1);
            visited.remove(neighbor);
        }
    }




}
