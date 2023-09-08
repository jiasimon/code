package com.sjia.Leetcode;

import java.util.*;

public class WordLadder {
    //  #127. Word Ladder   https://leetcode.com/problems/word-ladder/
    /*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"] Output: 5
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0

    1 <= beginWord.length <= 10
    endWord.length == beginWord.length
    1 <= wordList.length <= 5000
    wordList[i].length == beginWord.length
    */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int ladderLength = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        if (newWord.equals(endWord)) {
                            return ladderLength + 1;
                        }
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordChars[j] = originalChar; // revert the change
                }
            }
            ladderLength++;
        }

        return 0;
    }


    // bfs, set
    // 68 ms, 76.66%; 44.5 MB, 86.44%
    public int ladderLength_bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        int ans = 0;
        Queue<String> q = new ArrayDeque<>(Arrays.asList(beginWord));

        while (!q.isEmpty()) {
            ++ans;
            for (int sz = q.size(); sz > 0; --sz) {
                StringBuilder sb = new StringBuilder(q.poll());
                for (int i = 0; i < sb.length(); ++i) {
                    final char cache = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; ++c) {
                        sb.setCharAt(i, c);
                        final String word = sb.toString();
                        if (word.equals(endWord))
                            return ans + 1;
                        if (wordSet.contains(word)) {
                            q.offer(word);
                            wordSet.remove(word);
                        }
                    }
                    sb.setCharAt(i, cache);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();

        // Test case
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = solution.ladderLength_bfs(beginWord, endWord, wordList);
        System.out.println("Ladder Length: " + result);  // Output: 5
    }


}
