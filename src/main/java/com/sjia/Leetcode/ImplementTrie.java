package com.sjia.Leetcode;

public class ImplementTrie {
    // #208. Implement Trie (Prefix Tree)   https://leetcode.com/problems/implement-trie-prefix-tree/description/
    /*
    A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
    There are various applications of this data structure, such as autocomplete and spellchecker.
    Explanation
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // return True
    trie.search("app");     // return False
    trie.startsWith("app"); // return True
    trie.insert("app");
    trie.search("app");     // return True
     */

/*

    class Trie {
        private boolean isEndOfWord;
        private Trie[] children;

        public Trie() {
            children = new Trie[26];
            isEndOfWord = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null)  {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;

        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEndOfWord;

        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }

*/


    // use TrieNode class with Trie
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    class Trie {

        private TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (final char c : word.toCharArray()) {
                final int i = c - 'a';
                if (node.children[i] == null)
                    node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            TrieNode node = find(word);
            return node != null && node.isWord;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }



        private TrieNode find(String prefix) {
            TrieNode node = root;
            for (final char c : prefix.toCharArray()) {
                final int i = c - 'a';
                if (node.children[i] == null)
                    return null;
                node = node.children[i];
            }
            return node;
        }
    }



}
