package com.sjia.Leetcode;

public class BTreeTilt {
    // #563 https://leetcode.com/problems/binary-tree-tilt/
    // refer to #543 BTreeDiameter


    //Runtime: 1 ms, faster than 50.44% of Java online submissions for Binary Tree Tilt.
    //Memory Usage: 43.2 MB, less than 8.90% of Java online submissions for Binary Tree Tilt.

    int result = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        result += Math.abs(left -right);
        return left+right+root.val;
    }


}
