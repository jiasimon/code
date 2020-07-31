package com.sjia.Leetcode;

public class InvertBinaryTree {
    // #226 https://leetcode.com/problems/invert-binary-tree/

    // recursive
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
    //Memory Usage: 39.6 MB, less than 5.07% of Java online submissions for Invert Binary Tree.
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


}
