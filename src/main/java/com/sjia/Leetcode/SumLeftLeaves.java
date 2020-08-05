package com.sjia.Leetcode;

public class SumLeftLeaves {

    // #404 https://leetcode.com/problems/sum-of-left-leaves/
    // Find the sum of all left leaves in a given binary tree.

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
    //Memory Usage: 37.1 MB, less than 87.17% of Java online submissions for Sum of Left Leaves.

    int sum=0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if ( root.left !=null &&   root.left.left == null && root.left.right == null)
            sum += root.left.val;
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }


}
