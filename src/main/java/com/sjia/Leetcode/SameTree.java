package com.sjia.Leetcode;

public class SameTree {
    // #100 https://leetcode.com/problems/same-tree/

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


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
    //Memory Usage: 38.5 MB, less than 5.02% of Java online submissions for Same

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else {
            if (p.val != q.val)  return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }


}
