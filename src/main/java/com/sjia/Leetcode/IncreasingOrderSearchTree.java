package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    // #897 https://leetcode.com/problems/increasing-order-search-tree/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
    //Memory Usage: 37.1 MB, less than 70.24% of Java online submissions for Increasing Order Search Tree.
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> tmp = new ArrayList<>();
        helper(root, tmp);
        TreeNode res = new TreeNode(0), cur = res;
        for (int i: tmp) {
            cur.right = new TreeNode(i);
            cur = cur.right;
        }
        return res.right;

    }

    private void helper(TreeNode root, List<Integer> tmp) {
        if (root==null) return;
        helper(root.left, tmp);
        tmp.add(root.val);
        helper(root.right, tmp);
    }

}
