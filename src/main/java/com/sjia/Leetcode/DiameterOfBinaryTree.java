package com.sjia.Leetcode;

public class DiameterOfBinaryTree {
    // #543. Diameter of Binary Tree    https://leetcode.com/problems/diameter-of-binary-tree/description/

    /*
    Given the root of a binary tree, return the length of the diameter of the tree.

    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    The length of a path between two nodes is represented by the number of edges between them.


     */


    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxDiameter;
    }

    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        // Update maxDiameter if the sum of left and right depths is greater
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return the maximum depth of the current node's children plus 1
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Example: Construct the binary tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);
    }


}
