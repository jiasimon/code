package com.sjia.Leetcode;

public class SymmetricTree {

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
    //#101 https://leetcode.com/problems/symmetric-tree/

    // Runtime: 1 ms, faster than 39.46% of Java online submissions for Symmetric Tree.
    //Memory Usage: 40.3 MB, less than 5.05% of Java online submissions for Symmetric Tree.

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }

    public boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && checkSymmetric(left.left, right.right) &&
                checkSymmetric(left.right, right.left);
    }

}
