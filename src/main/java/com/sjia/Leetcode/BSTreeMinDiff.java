package com.sjia.Leetcode;

public class BSTreeMinDiff {
    // #530. Minimum Absolute Difference in BST
    // https://leetcode.com/problems/minimum-absolute-difference-in-bst/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Absolute Difference in BST.
    //Memory Usage: 39.3 MB, less than 71.14% of Java online submissions for Minimum Absolute Difference in BST.
    int min = Integer.MAX_VALUE;
    Integer prev = null ;

    public int getMinimumDifference(TreeNode root) {
        if (root==null) return min;
        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);
        return min;

    }

}
