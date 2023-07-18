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





}
