package com.sjia.Leetcode700;

import java.util.HashMap;
import java.util.Map;

public class PrefixSuffixSearch {
    // #745. Prefix and Suffix Search   https://leetcode.com/problems/prefix-and-suffix-search/description/
    /*
    use a Trie with combined prefix-suffix keys:

    Store each word in the Trie multiple times in a special format:
        For word "apple", store it in the Trie as "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple".
        The delimiter { (or any non-alphabetic character) ensures a unique separation between prefix and suffix.
    When searching for f(prefix, suffix), we search in the Trie for suffix + "{" + prefix.
     */


        private TrieNode root;

        public PrefixSuffixSearch(String[] words) {
            root = new TrieNode();
            for (int index = 0; index < words.length; index++) {
                String word = words[index];
                String newWord = word + "{";  // Delimiter to separate suffixes
                for (int j = 0; j <= word.length(); j++) {
                    insert(newWord.substring(j) + word, index);
                }
            }
        }

        private void insert(String key, int index) {
            TrieNode node = root;
            for (char c : key.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
                node.index = index;  // Store the latest index
            }
        }

        public int f(String prefix, String suffix) {
            return search(suffix + "{" + prefix);
        }

        private int search(String key) {
            TrieNode node = root;
            for (char c : key.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return -1;
                }
                node = node.children.get(c);
            }
            return node.index;
        }

        // Trie Node definition
        private static class TrieNode {
             Map<Character, TrieNode> children;
            int index;

            public TrieNode() {
                children = new HashMap<>();
                index = -1;
            }
        }

        public static void main(String[] args) {
            String[] words = {"apple", "banana", "appl", "app"};
            PrefixSuffixSearch wf = new PrefixSuffixSearch(words);

            System.out.println(wf.f("a", "e")); // Expected Output: 0 (apple)
            System.out.println(wf.f("ap", "e")); // Expected Output: 0 (apple)
            System.out.println(wf.f("b", "a")); // Expected Output: 1 (banana)
            System.out.println(wf.f("appl", "")); // Expected Output: 2 (appl)
            System.out.println(wf.f("x", "y")); // Expected Output: -1 (Not found)
        }
}
