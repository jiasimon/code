package com.sjia.Leetcode;

public class BinaryTreeMaximumPathSum {
    // #124. Binary Tree Maximum Path Sum https://leetcode.com/problems/binary-tree-maximum-path-sum/ #fb


    /*
    A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

    The path sum of a path is the sum of the node's values in the path.

    Given the root of a binary tree, return the maximum path sum of any non-empty path.

    Input: root = [-10,9,20,null,null,15,7] Output: 42

    The number of nodes in the tree is in the range [0, 3 * 10^4].
    -1000 <= Node.val <= 1000
     */


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

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

        // Create the binary tree, refer to #113 https://leetcode.com/problems/path-sum-ii/
        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Add more nodes to the tree if needed

        // Calculate the maximum path sum
        int result = solution.maxPathSum(root);

        // Print the result: 48
        System.out.println("Maximum Path Sum: " + result);
    }

}
