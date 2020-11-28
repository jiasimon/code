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


    // left-root-right
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




    // Runtime: 16 ms, faster than 38.27% of Java online submissions for Binary Search Tree Iterator.
    //Memory Usage: 44.2 MB, less than 37.30% of Java online submissions for Binary Search Tree Iterator.
    class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            leftChildrenInOrder(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode tmp = stack.pop();
            if (tmp.right != null) leftChildrenInOrder(tmp.right);
            return tmp.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return stack.size() > 0 ;
        }

        private void leftChildrenInOrder(TreeNode node) {
            while( node != null) {
                stack.push(node);
                node = node.left;
            }

        }
    }



    // PreOrder Iterator
    class BSTPreOrderIterator {

        Stack<TreeNode> stack = new Stack<>();
        public BSTPreOrderIterator(TreeNode root) {
            stack.add(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode tmp = stack.pop();
            if (tmp.right != null) stack.push(tmp.right);
            if (tmp.left != null) stack.push(tmp.left);
            return tmp.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

    }


}
