package com.sjia.Leetcode;

public class BinaryTreeMaximumPathSum {
    // #124 https://leetcode.com/problems/binary-tree-maximum-path-sum/ #fb
    // Given a non-empty binary tree, find the maximum path sum.
    //
    // For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections.
    // The path must contain at least one node and does not need to go through the root.
    // The number of nodes in the tree is in the range [0, 3 * 104].
    // -1000 <= Node.val <= 1000


    //
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Maximum Path Sum.
    // Memory Usage: 40.8 MB, less than 57.79% of Java online submissions for Binary Tree Maximum Path Sum.
    int maxRes;
    public int maxPathSum(TreeNode root) {
        maxRes = Integer.MIN_VALUE;
        maxPathHelper(root);
        return maxRes;
    }

    private int maxPathHelper(TreeNode node) {
        if( node == null) return 0;
        int left = Math.max(0, maxPathHelper(node.left));
        int right = Math.max(0, maxPathHelper(node.right));
        maxRes = Math.max(maxRes, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

/*
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
    */

}
