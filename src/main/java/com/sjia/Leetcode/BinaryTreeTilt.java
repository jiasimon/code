package com.sjia.Leetcode;

public class BinaryTreeTilt {
    // #563. Binary Tree Tilt   https://leetcode.com/problems/binary-tree-tilt/description/

    /*
    Given the root of a binary tree, return the sum of every tree node's tilt.

    The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
    The rule is similar if the node does not have a right child.

         1
       /   \
      2     3
     / \     \
    4   5     7

     */


    int tilt = 0;

    public int findTilt(TreeNode root) {
        calculateSum(root);
        return tilt;
    }

    private int calculateSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = calculateSum(node.left);
        int rightSum = calculateSum(node.right);

        tilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;
    }

    public static void main(String[] args) {
        BinaryTreeTilt solution = new BinaryTreeTilt();

        // Test case: creating a sample binary tree
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, null, new TreeNode(7));
        TreeNode root = new TreeNode(1, left, right);

        System.out.println("Test Case 1: " + solution.findTilt(root)); // Output: 9
    }


}
