package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    // #145. Binary Tree Postorder Traversal    https://leetcode.com/problems/binary-tree-postorder-traversal/
    /*
    Given the root of a binary tree, return the postorder traversal of its nodes' values.
    Input: root = [1,null,2,3]  Output: [3,2,1]

     */

    // recursive
    // 0, 100% ; 40.9 MB, 62.4%
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helperPostorder(root, res);
        return res;
    }


    private void helperPostorder(TreeNode root, List<Integer> res) {
        if (root == null ) return;
        helperPostorder(root.left, res);
        helperPostorder(root.right, res);
        res.add(root.val);
    }
}
