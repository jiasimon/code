package com.sjia.Leetcode;

public class TreeMaxLength {

    // #104. Maximum Depth of Binary Tree https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    //Memory Usage: 39.3 MB, less than 71.77% of Java online submissions for Maximum Depth of Binary Tree.


    public int maxDepth(TreeNode root) {
        if (root== null) return  0;
        else return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)) );

    }

}
