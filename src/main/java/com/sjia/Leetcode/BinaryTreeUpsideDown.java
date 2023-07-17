package com.sjia.Leetcode;

public class BinaryTreeUpsideDown {
    // #156. Binary Tree Upside Down    #premium    #https://walkccc.me/LeetCode/problems/0156/
    /*
    Input:
        1
       / \
      2   3
     / \
    4   5

    output
       4
      / \
     5   2
        / \
       3   1

     */


    // recursive
    /*
    You can turn a binary tree upside down with the following steps:

    The original left child becomes the new root.
    The original root becomes the new right child.
    The original right child becomes the new left child.

     */
    public TreeNode upsideDownBinaryTreeRecursive(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTreeRecursive(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }




    public static void main(String[] args) {
        BinaryTreeUpsideDown solution = new BinaryTreeUpsideDown();

        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Upside-down the binary tree
        TreeNode newRoot = solution.upsideDownBinaryTreeRecursive(root);

        // Print the upside-down binary tree
        System.out.print("Upside-Down Binary Tree: ");
        printTree(newRoot);  // Expected output: 4 5 2 3 1
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        if (root.left != null) {
            printTree(root.left);
        }

        if (root.right != null) {
            printTree(root.right);
        }
    }

}
