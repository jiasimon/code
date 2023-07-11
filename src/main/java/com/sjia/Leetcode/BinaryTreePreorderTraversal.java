package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    // #144. Binary Tree Preorder Traversal https://leetcode.com/problems/binary-tree-preorder-traversal/
    /*
    Given the root of a binary tree, return the preorder traversal of its nodes' values.
    Input: root = [1,null,2,3]  Output: [1,2,3]
    Input: root = []    Output: []
     */

    // recursive, PreOrder
    // 0 ms , 100%; 41.1 MB, 28.42%
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helperPreOrder(root, res);
        return res;
    }

    private void helperPreOrder(TreeNode root, List<Integer> res) {
        if (root == null ) return;
        res.add(root.val);
        helperPreOrder(root.left, res);
        helperPreOrder(root.right, res);
    }







}
