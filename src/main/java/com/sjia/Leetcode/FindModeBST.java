package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeBST {
    // #501. Find Mode in Binary Search Tree    https://leetcode.com/problems/find-mode-in-binary-search-tree/

    /*
    Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

    If the tree has more than one mode, return them in any order.

     */


    private Map<Integer, Integer> freqMap;
    private int maxFreq;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        freqMap = new HashMap<>();
        maxFreq = 0;

        traverse(root);

        List<Integer> modes = new ArrayList<>();
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == maxFreq) {
                modes.add(key);
            }
        }

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.left);

        freqMap.put(node.val, freqMap.getOrDefault(node.val, 0) + 1);
        maxFreq = Math.max(maxFreq, freqMap.get(node.val));

        traverse(node.right);
    }

    
}
