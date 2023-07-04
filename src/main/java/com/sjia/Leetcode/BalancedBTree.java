package com.sjia.Leetcode;

public class BalancedBTree {

    // #110. Balanced Binary Tree  https://leetcode.com/problems/balanced-binary-tree/

    // top down
    // Runtime: 1 ms, faster than 68.36% of Java online submissions for Balanced Binary Tree.
    //Memory Usage: 39.2 MB, less than 90.27% of Java online submissions for Balanced Binary Tree
/*
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
    }*/


    // bottom up Runtime: 1 ms, faster than 68.36% of Java online submissions for Balanced Binary Tree.
    //Memory Usage: 41.7 MB, less than 5.06% of Java online submissions for Balanced Binary Tree.

    public boolean isBalanced(TreeNode root) {
        return helper(root)>=0;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }



    
    public boolean isBalancedBTree(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // If the subtree is balanced, it returns the height of the subtree. If the subtree is unbalanced, it returns -1.
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
