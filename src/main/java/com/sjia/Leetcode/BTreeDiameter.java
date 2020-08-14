package com.sjia.Leetcode;

public class BTreeDiameter {

    // #543 https://leetcode.com/problems/diameter-of-binary-tree/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
    //Memory Usage: 39.5 MB, less than 66.65% of Java online submissions for Diameter of Binary Tree.
    int result = 0;
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

}
