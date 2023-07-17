package com.sjia.Leetcode;

public class BinaryTreeUpsideDown {
    // #156. Binary Tree Upside Down    #premium    #https://walkccc.me/LeetCode/problems/0156/
    /*
    Input:
        1
       / \
      2   3
     / \
    4   5

    output
       4
      / \
     5   2
        / \
       3   1

     */


    // recursive
    public TreeNode upsideDownBinaryTreeRecursive(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTreeRecursive(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }


}
