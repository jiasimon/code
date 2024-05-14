package com.sjia.Leetcode600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
    // #648. Replace Words  https://leetcode.com/problems/replace-words/description/
    /*
    Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
    Output: "the cat was rat by the bat"
     */

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWord = true;
        }

        public String findRoot(String word) {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) break;
                sb.append(c);
                node = node.children.get(c);
                if (node.isWord) return sb.toString();
            }
            return word;
        }

    }

    // Trie
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        StringBuilder result = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (result.length() > 0) result.append(" ");
            result.append(trie.findRoot(word));
        }
        return result.toString();
    }


    public static void main(String[] args) {
        ReplaceWords solution = new ReplaceWords();

        // Test Case
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println("Test Case 1: " + solution.replaceWords(dictionary, sentence)); // Output: "the cat was rat by the bat"
    }


}
