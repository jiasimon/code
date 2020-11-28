package com.sjia.Leetcode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    // #173 https://leetcode.com/problems/binary-search-tree-iterator/  #fb
    // Implement an iterator over a binary search tree (BST).
    // Your iterator will be initialized with the root node of a BST
    // Calling next() will return the next smallest number in the BST

    // use Stack to store directed left children from root.
    // When next() be called,
    // just pop one element and process its right child as new root.


    // Runtime: 16 ms, faster than 38.27% of Java online submissions for Binary Search Tree Iterator.
    //Memory Usage: 44 MB, less than 65.65% of Java online submissions for Binary Search Tree Iterator.
    
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }


}
