package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    // #144. Binary Tree Preorder Traversal https://leetcode.com/problems/binary-tree-preorder-traversal/
    /*
    root -> left -> right
    Given the root of a binary tree, return the preorder traversal of its nodes' values.
    Input: root = [1,null,2,3]  Output: [1,2,3]
    Input: root = []    Output: []
     */

    // recursive, PreOrder
    // 0 ms , 100%; 41.1 MB, 28.42%
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helperPreorder(root, res);
        return res;
    }

    private void helperPreorder(TreeNode root, List<Integer> res) {
        if (root == null ) return;
        res.add(root.val);
        helperPreorder(root.left, res);
        helperPreorder(root.right, res);
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



    public static void main(String[] args) {
        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();

        // Test case: Create a binary tree
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;

        List<Integer> result = solution.preorderTraversal(root);

        // Print the preorder traversal result
        System.out.println("Preorder Traversal:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }




}
