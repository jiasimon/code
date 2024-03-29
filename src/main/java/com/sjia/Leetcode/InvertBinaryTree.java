package com.sjia.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    // #226. Invert Binary Tree https://leetcode.com/problems/invert-binary-tree/

    // recursive
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
    //Memory Usage: 39.6 MB, less than 5.07% of Java online submissions for Invert Binary Tree.

    // postOrder ? bottom up, first recur then swap
    // invert 2, invert 1, invert 3, swap 1-3; invert 7, invert 6, invert 9, swap 6-9; swap 2-7
    public TreeNode invertTree(TreeNode root) {
        if ( root == null ) {
            return null;
        }
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }


    // top down, first swap, then recur
    // 2 - 7  swap, invert 7, 6-9 swap; invert 2, swap 1-3
    public TreeNode invertTreeTopDown(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right children of the current node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTreeTopDown(root.left);
        invertTreeTopDown(root.right);

        return root;
    }



    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        // Create a binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Invert the binary tree
        TreeNode invertedRoot = invertBinaryTree.invertTree(root);

        // Output the inverted tree (Breadth-First Search)
        System.out.println("Inverted Binary Tree:");
        printTree(invertedRoot);
    }

    // Helper method to print the binary tree (Breadth-First Search)
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

}
