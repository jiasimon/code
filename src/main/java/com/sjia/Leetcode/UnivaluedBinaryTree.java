package com.sjia.Leetcode;

public class UnivaluedBinaryTree {
    // #965 https://leetcode.com/problems/univalued-binary-tree/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
    // Memory Usage: 36.4 MB, less than 98.45% of Java online submissions for Univalued Binary Tree.
    int tmp = -1;
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        if (tmp<0) tmp = root.val;
        return (root.val == tmp) && isUnivalTree(root.left) && isUnivalTree(root.right);
    }



}
