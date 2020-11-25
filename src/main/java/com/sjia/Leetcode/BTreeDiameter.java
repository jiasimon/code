package com.sjia.Leetcode;

public class BTreeDiameter {

    // #543 https://leetcode.com/problems/diameter-of-binary-tree/  #fb
    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    // This path may or may not pass through the root.

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
    //Memory Usage: 39.5 MB, less than 66.65% of Java online submissions for Diameter of Binary Tree.
/*    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        result = Math.max(result, left + right );
        return Math.max(left, right) + 1;

    }
    */



    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
    //Memory Usage: 38.9 MB, less than 67.31% of Java online submissions for Diameter of Binary Tree.
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        res = Math.max(res, l + r);
        return Math.max(l, r) +1;

    }



}
