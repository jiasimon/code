package com.sjia.Leetcode;

public class BalancedBTree {

    // #110. https://leetcode.com/problems/balanced-binary-tree/

    // top down
    // Runtime: 1 ms, faster than 68.36% of Java online submissions for Balanced Binary Tree.
    //Memory Usage: 39.2 MB, less than 90.27% of Java online submissions for Balanced Binary Tree

    public boolean isBalanced(TreeNode root) {
        if (root ==null) return true;
        else {
            return Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right)) <=1 &&
                    isBalanced(root.left) && isBalanced(root.right) ;
        }
    }

    static int getTreeHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }


}
