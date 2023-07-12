package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    // #145. Binary Tree Postorder Traversal    https://leetcode.com/problems/binary-tree-postorder-traversal/
    /*
    left -> right -> root
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


    // stack, ArrayList
    // 1 ms, 18.12% ; 40.7 MB, 85.41%
    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(0,curr.val);
            if(curr.left!=null) {
                stack.push(curr.left);
            }
            if(curr.right!=null) {
                stack.push(curr.right);
            }
        }
        return res;
    }



}
