package com.sjia.Leetcode;

public class TreePathSum {
    // #112. Path Sum  https://leetcode.com/problems/path-sum/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
    //Memory Usage: 39.3 MB, less than 57.05% of Java online submissions for Path Sum.

    // recursive
    public boolean hasPathSum(TreeNode root, int sum) {
        if ( root == null) return false;
        if (root.left == null & root.right ==null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }


/*
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }
    */

}
