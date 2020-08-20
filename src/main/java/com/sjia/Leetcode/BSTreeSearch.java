package com.sjia.Leetcode;

public class BSTreeSearch {

    // #700 https://leetcode.com/problems/search-in-a-binary-search-tree/
    // find the node in the BST that the node's value equals the given value
    // If such node doesn't exist, you should return NULL.

    // recursive
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
    //Memory Usage: 48.8 MB, less than 27.86% of Java online submissions for Search in a Binary Search Tree.

    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        if(root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }


    // iterative
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
    //Memory Usage: 48.8 MB, less than 25.72% of Java online submissions for Search in a Binary Search Tree.
/*
    public TreeNode searchBST(TreeNode root, int val) {
        while (root!= null && root.val != val){
            if (val < root.val) root = root.left;
            else root = root.right;
        }
        return root;
    }*/



}
