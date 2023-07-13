package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    // #94. Binary Tree Inorder Traversal  https://leetcode.com/problems/binary-tree-inorder-traversal/

    /*
    left -> root -> right
    Given the root of a binary tree, return the inorder traversal of its nodes' values.
     */



    // recursive, InOrder
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

    // stack
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if ( root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current !=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;

    }



    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal inorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = inorderTraversal.inorderTraversalStack(root);

        System.out.println(result);
    }

}
