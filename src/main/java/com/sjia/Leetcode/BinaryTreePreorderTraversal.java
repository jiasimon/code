package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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





    // Stack
    // 1ms, 5.78% ; 41 MB, 28.42%
    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
//        stack.add(root);
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            res.add(currNode.val);
            if(currNode.right != null) stack.push(currNode.right);  // The node we add last is visited first. we need add the right child before the left child.
            if(currNode.left != null) stack.push(currNode.left);
//            if(currNode.right != null) stack.push(currNode.right);
        }
        return res;
    }




}
